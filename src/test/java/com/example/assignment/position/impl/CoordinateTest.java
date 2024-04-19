package com.example.assignment.position.impl;

import com.example.assignment.position.impl.Coordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CoordinateTest {

  @Test
  void testIncrement() {
    // Create a coordinate with initial value 5
    Coordinate coordinate = new Coordinate(5);

    // Increment the coordinate by 3
    coordinate.increment(3);

    // Check if the value is incremented correctly
    assertEquals(8, coordinate.getValue());
  }

  @Test
  void testDecrement() {
    // Create a coordinate with initial value 10
    Coordinate coordinate = new Coordinate(10);

    // Decrement the coordinate by 4
    coordinate.decrement(4);

    // Check if the value is decremented correctly
    assertEquals(6, coordinate.getValue());
  }

  @Test
  void testEquals() {
    // Create two coordinates with the same value
    Coordinate coordinate1 = new Coordinate(7);
    Coordinate coordinate2 = new Coordinate(7);

    // Check if they are equal
    assertEquals(coordinate1, coordinate2);
  }

  @Test
  void testNotEquals() {
    // Create two coordinates with different values
    Coordinate coordinate1 = new Coordinate(3);
    Coordinate coordinate2 = new Coordinate(8);

    // Check if they are not equal
    assertNotEquals(coordinate1, coordinate2);
  }
}
