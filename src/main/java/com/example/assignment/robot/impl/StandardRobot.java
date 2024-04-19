package com.example.assignment.robot.impl;

import com.example.assignment.navigation.impl.NavigationCommand;
import com.example.assignment.position.impl.Coordinate;
import com.example.assignment.position.impl.Orientation;
import com.example.assignment.position.impl.Position;
import com.example.assignment.robot.Robot;

/**
 * Represents a robot with a position and orientation.
 */
public class StandardRobot implements Robot {
  private Coordinate x, y; // Current position
  private Orientation orientation; // Current orientation

  /**
   * Constructs a new Standard Robot with the specified position and orientation.
   *
   * @param x            The x-coordinate of the initial position.
   * @param y            The y-coordinate of the initial position.
   * @param orientation  The initial orientation of the robot.
   */
  public StandardRobot(Coordinate x, Coordinate y, Orientation orientation) {
    this.x = x;
    this.y = y;
    this.orientation = orientation;
  }

  /**
   * Turns the robot 90 degrees to the left.
   */
  public void turnLeft() {
    orientation = switch (orientation) {
      case NORTH -> Orientation.WEST;
      case EAST -> Orientation.NORTH;
      case SOUTH -> Orientation.EAST;
      case WEST -> Orientation.SOUTH;
    };
  }

  /**
   * Turns the robot 90 degrees to the right.
   */
  public void turnRight() {
    orientation = switch (orientation) {
      case NORTH -> Orientation.EAST;
      case EAST -> Orientation.SOUTH;
      case SOUTH -> Orientation.WEST;
      case WEST -> Orientation.NORTH;
    };
  }

  /**
   * Moves the robot forward by the specified distance in the direction it is facing.
   *
   * @param distance The distance to move forward.
   */
  public void moveForward(int distance) {
    switch (orientation) {
      case NORTH -> y.decrement(distance);
      case EAST -> x.increment(distance);
      case SOUTH -> y.increment(distance);
      case WEST -> x.decrement(distance);
    }
  }

  /**
   * Retrieves the current orientation of the robot.
   *
   * @return The current orientation of the robot.
   */
  public Orientation getCurrentOrientation() {
    return orientation;
  }

  /**
   * Executes the specified navigation command and returns the updated position of the robot.
   *
   * @param command The navigation command to execute.
   * @return The updated position of the robot after executing the command.
   */
  @Override
  public RobotState executeCommand(NavigationCommand command) {
    switch (command) {
      case LEFT -> turnLeft();
      case RIGHT -> turnRight();
      case FORWARD -> moveForward(1);
    }
    return new RobotState(getPosition(), orientation);
  }

  /**
   * Retrieves the current position of the robot.
   *
   * @return The current position of the robot.
   */
  @Override
  public Position getPosition() {
    return new Position(new Coordinate(x.getValue()),
                        new Coordinate(y.getValue()));
  }

  /**
   * Retrieves the current state of the robot.
   *
   * @return The current state of the robot.
   */
  public RobotState getCurrentRobotState() {
    return new RobotState(getPosition(), getCurrentOrientation());
  }
}
