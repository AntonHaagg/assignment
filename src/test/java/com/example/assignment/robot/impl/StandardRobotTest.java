package com.example.assignment.robot.impl;


import org.junit.jupiter.api.Test;

import com.example.assignment.navigation.impl.NavigationCommand;
import com.example.assignment.position.impl.Coordinate;
import com.example.assignment.position.impl.Orientation;
import com.example.assignment.position.impl.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StandardRobotTest {
  @Test
  void testExecuteCommands() {
    // Create a robot at position (0, 0) facing EAST
    StandardRobot robot = new StandardRobot(new Coordinate(0), new Coordinate(0), Orientation.EAST);

    // Execute some navigation commands
    robot.executeCommand(NavigationCommand.RIGHT); // Turn RIGHT (now facing SOUTH)
    robot.executeCommand(NavigationCommand.FORWARD); // Move FORWARD (to position (0, 1))
    robot.executeCommand(NavigationCommand.LEFT); // Turn LEFT (now facing EAST)
    robot.executeCommand(NavigationCommand.FORWARD); // Move FORWARD (to position (1, 1))
    robot.executeCommand(NavigationCommand.FORWARD); // Move FORWARD (to position (2, 1))

    // Verify the final position and orientation
    Position expectedPosition = new Position(new Coordinate(2), new Coordinate(1));
    Orientation expectedOrientation = Orientation.EAST;
    assertEquals(expectedPosition, robot.getPosition());
    assertEquals(expectedOrientation, robot.getCurrentOrientation());
  }

  @Test
  void testExecuteCommandsScenario2() {
    // Create a robot at position (1, 1) facing NORTH
    StandardRobot robot = new StandardRobot(new Coordinate(1), new Coordinate(1), Orientation.NORTH);

    // Execute some navigation commands
    robot.executeCommand(NavigationCommand.FORWARD); // Move FORWARD (to position (1, 0))
    robot.executeCommand(NavigationCommand.LEFT); // Turn LEFT (now facing WEST)
    robot.executeCommand(NavigationCommand.FORWARD); // Move FORWARD (to position (0, 0))
    robot.executeCommand(NavigationCommand.RIGHT); // Turn RIGHT (now facing NORTH)
    robot.executeCommand(NavigationCommand.FORWARD); // Move FORWARD (to position (0, -1))

    // Verify the final position and orientation
    Position expectedPosition = new Position(new Coordinate(0), new Coordinate(-1));
    Orientation expectedOrientation = Orientation.NORTH;
    assertEquals(expectedPosition, robot.getPosition());
    assertEquals(expectedOrientation, robot.getCurrentOrientation());
  }

  @Test
  void testExecuteCommandsScenario3() {
    // Create a robot at position (0, 0) facing SOUTH
    StandardRobot robot = new StandardRobot(new Coordinate(0), new Coordinate(0), Orientation.SOUTH);

    // Execute some navigation commands
    robot.executeCommand(NavigationCommand.FORWARD); // Move FORWARD (to position (0, 1))
    robot.executeCommand(NavigationCommand.LEFT); // Turn LEFT (now facing EAST)
    robot.executeCommand(NavigationCommand.FORWARD); // Move FORWARD (to position (1, 1))
    robot.executeCommand(NavigationCommand.RIGHT); // Turn RIGHT (now facing SOUTH)
    robot.executeCommand(NavigationCommand.FORWARD); // Move FORWARD (to position (1, 2))

    // Verify the final position and orientation
    Position expectedPosition = new Position(new Coordinate(1), new Coordinate(2));
    Orientation expectedOrientation = Orientation.SOUTH;
    assertEquals(expectedPosition, robot.getPosition());
    assertEquals(expectedOrientation, robot.getCurrentOrientation());
  }
}