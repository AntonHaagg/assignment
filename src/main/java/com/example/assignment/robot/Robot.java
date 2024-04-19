package com.example.assignment.robot;

import com.example.assignment.navigation.impl.NavigationCommand;
import com.example.assignment.position.impl.Orientation;
import com.example.assignment.position.impl.Position;
import com.example.assignment.robot.impl.RobotState;

/**
 * Represents a robot with a position and orientation.
 */
public interface Robot {

  void turnLeft();

  void turnRight();

  void moveForward(int distance);

  /**
   * Retrieves the current position of the robot.
   *
   * @return The current position of the robot.
   */
  Position getPosition();

  /**
   * Executes the specified navigation command and returns the updated position of the robot.
   *
   * @param command The navigation command to execute.
   * @return The updated position of the robot after executing the command.
   */
  RobotState executeCommand(NavigationCommand command);

  Orientation getCurrentOrientation();

  RobotState getCurrentRobotState();
}

