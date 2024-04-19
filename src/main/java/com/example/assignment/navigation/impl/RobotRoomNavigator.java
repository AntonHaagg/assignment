package com.example.assignment.navigation.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.lang.NonNull;

import com.example.assignment.exception.InvalidNavigationCommandException;
import com.example.assignment.robot.impl.RobotState;
import com.example.assignment.robot.impl.StandardRobot;
import com.example.assignment.room.impl.Room;

/**
 * Represents a navigator for a robot within a room.
 */
public class RobotRoomNavigator {
  private final Room room;
  private final StandardRobot robot;

  /**
   * Constructs a new RobotRoomNavigator with the specified room and robot.
   *
   * @param room  The room in which the robot will navigate.
   * @param robot The robot to control.
   */
  public RobotRoomNavigator(@NonNull Room room,
                            @NonNull StandardRobot robot) {
    this.room = room;
    this.robot = robot;
  }

  /**
   * Executes the specified navigation commands and returns the result.
   *
   * @param commands The sequence of navigation commands to execute.
   * @return The result of executing the navigation commands.
   */
  @NonNull
  public NavigationResult executeCommands(String commands) {
    List<NavigationCommand> navigationCommands = parseNavigationCommands(commands);
    if(navigationCommands.isEmpty()) {
      return new NavigationResult(List.of(),
                                  NavigationResultType.INVALID_NAVIGATION_COMMAND);
    }

    if (!isValidPosition(robot.getCurrentRobotState())) {
      return new NavigationResult(List.of(robot.getCurrentRobotState()),
                                  NavigationResultType.ENTERED_VOID);
    }

    List<RobotState> robotStates = calculateRobotStates(navigationCommands);

    if (robotStates.size() <= navigationCommands.size()) {
      robotStates.add(robot.getCurrentRobotState());
      return new NavigationResult(robotStates,
                                  NavigationResultType.ENTERED_VOID);
    }

    return new NavigationResult(robotStates,
                                NavigationResultType.FINISHED);
  }

  /**
   * Parses the specified navigation commands and returns a list of parsed commands.
   *
   * @param commands The sequence of navigation commands to parse.
   * @return A list of parsed navigation commands.
   */
  private List<NavigationCommand> parseNavigationCommands(String commands) {
    try {
      return NavigationCommandParserUtil.parseCommands(commands);
    } catch (InvalidNavigationCommandException ex) {
      return List.of();
    }
  }

  /**
   * Calculates the robot states based on the given navigation commands.
   *
   * @param navigationCommands The list of navigation commands to execute.
   * @return A list of robot states after executing the navigation commands.
   */
  private List<RobotState> calculateRobotStates(List<NavigationCommand> navigationCommands) {
    List<RobotState> robotStates = new ArrayList<>(List.of(robot.getCurrentRobotState()));
    robotStates.addAll(calculateValidRobotStates(navigationCommands));
    return robotStates;
  }

  /**
   * Retrieves the list of robot states obtained by executing the given navigation commands until finished or
   * invalid position is encountered.
   *
   * @param navigationCommands The list of navigation commands to execute.
   * @return The list of robot states representing the robot's path until finished or invalid position is reached.
   */
  private List<RobotState> calculateValidRobotStates(List<NavigationCommand> navigationCommands) {
    return navigationCommands.stream()
      .map(robot::executeCommand)
      .takeWhile(this::isValidPosition)
      .toList();
  }

  /**
     * Checks if the robot's current position is within the bounds of the room and on a valid tile.
     *
     * @return True if the robot's position is valid, false otherwise.
     */
  @NonNull
  private boolean isValidPosition(RobotState robotState) {
    return room.isValidPosition(robotState.position());
  }
}

