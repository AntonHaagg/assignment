package com.example.assignment.position.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PositionTest {

  @Test
  void testEquals() {
    // Create two positions with the same coordinates
    Position position1 = new Position(new Coordinate(3), new Coordinate(5));
    Position position2 = new Position(new Coordinate(3), new Coordinate(5));

    // Check if they are equal
    assertEquals(position1, position2);
  }

  @Test
  void testNotEquals() {
    // Create two positions with different coordinates
    Position position1 = new Position(new Coordinate(2), new Coordinate(4));
    Position position2 = new Position(new Coordinate(7), new Coordinate(9));

    // Check if they are not equal
    assertNotEquals(position1, position2);
  }

  @Test
  void testHashCode() {
    // Create two positions with the same coordinates
    Position position1 = new Position(new Coordinate(2), new Coordinate(4));
    Position position2 = new Position(new Coordinate(2), new Coordinate(4));

    // Check if their hash codes are equal
    assertEquals(position1.hashCode(), position2.hashCode());
  }
}
