package com.example.assignment.navigation;

import com.example.assignment.navigation.impl.NavigationResult;
import com.example.assignment.navigation.impl.NavigationResultType;
import com.example.assignment.navigation.impl.RobotRoomNavigator;
import com.example.assignment.position.impl.Coordinate;
import com.example.assignment.position.impl.Orientation;
import com.example.assignment.robot.impl.StandardRobot;
import com.example.assignment.room.impl.Room;
import org.junit.jupiter.api.Test;

public class RobotRoomNavigatorTest {

  // Constants representing different types of navigation commands
  public static final String INVALID_COMMAND = "INVALID";
  public static final String VOID_COMMAND = "FFLFFRF";
  public static final String VALID_COMMAND_2 = "RFRFFRFRF";
  public static final String VALID_COMMAND_1 = "RFLFFLRF";

  // Test method to verify navigation execution with valid commands
  @Test
  public void testExecuteCommands() {
    // Create a room and a robot
    Room room = new Room(5, 5);
    StandardRobot robot = new StandardRobot(new Coordinate(0),
                                            new Coordinate(0),
                                            Orientation.EAST);
    // Create a navigator for the robot within the room
    RobotRoomNavigator robotRoomNavigator = new RobotRoomNavigator(room, robot);

    // Execute navigation commands and verify the result
    NavigationResult navigationResult = robotRoomNavigator.executeCommands(VALID_COMMAND_1);
    assert(navigationResult.navigationResultType().is(NavigationResultType.FINISHED));
  }

  // Test method to verify navigation execution with another set of valid commands
  @Test
  public void testExecuteCommands2() {
    // Create a room and a robot
    Room room = new Room(5, 5);
    StandardRobot robot = new StandardRobot(new Coordinate(1),
                                            new Coordinate(2),
                                            Orientation.NORTH);
    // Create a navigator for the robot within the room
    RobotRoomNavigator robotRoomNavigator = new RobotRoomNavigator(room, robot);

    // Execute navigation commands and verify the result
    NavigationResult navigationResult = robotRoomNavigator.executeCommands(VALID_COMMAND_2);
    assert(navigationResult.navigationResultType().is(NavigationResultType.FINISHED));
  }

  // Test method to verify entering void condition
  @Test
  public void testExecuteCommands3() {
    // Create a room and a robot
    Room room = new Room(3, 3);
    StandardRobot robot = new StandardRobot(new Coordinate(2),
                                            new Coordinate(2),
                                            Orientation.NORTH);
    // Create a navigator for the robot within the room
    RobotRoomNavigator robotRoomNavigator = new RobotRoomNavigator(room, robot);

    // Execute navigation commands and verify the result
    NavigationResult navigationResult = robotRoomNavigator.executeCommands(VOID_COMMAND);
    assert(navigationResult.navigationResultType().is(NavigationResultType.ENTERED_VOID));
  }

  // Test method to verify handling of invalid navigation commands
  @Test
  public void testExecuteCommands4() {
    // Create a room and a robot
    Room room = new Room(3, 3);
    StandardRobot robot = new StandardRobot(new Coordinate(2),
                                            new Coordinate(2),
                                            Orientation.NORTH);
    // Create a navigator for the robot within the room
    RobotRoomNavigator robotRoomNavigator = new RobotRoomNavigator(room, robot);

    // Execute navigation commands and verify the result
    NavigationResult navigationResult = robotRoomNavigator.executeCommands(INVALID_COMMAND);
    assert(navigationResult.navigationResultType().is(NavigationResultType.INVALID_NAVIGATION_COMMAND));
  }
}
