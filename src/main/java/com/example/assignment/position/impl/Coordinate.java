package com.example.assignment.position.impl;

import java.util.Objects;

/**
 * Represents a coordinate value.
 */
public class Coordinate {
  private int value;

  /**
   * Constructs a new Coordinate with the specified initial value.
   *
   * @param value The initial value of the coordinate.
   */
  public Coordinate(int value) {
    this.value = value;
  }

  /**
   * Retrieves the current value of the coordinate.
   *
   * @return The current value of the coordinate.
   */
  public int getValue() {
    return value;
  }

  /**
   * Increments the value of the coordinate by the specified amount.
   *
   * @param amount The amount by which to increment the coordinate.
   */
  public void increment(int amount) {
    value += amount;
  }

  /**
   * Decrements the value of the coordinate by the specified amount.
   *
   * @param amount The amount by which to decrement the coordinate.
   */
  public void decrement(int amount) {
    value -= amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Coordinate that = (Coordinate) o;
    return value == that.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}


