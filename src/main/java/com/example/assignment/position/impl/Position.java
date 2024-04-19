package com.example.assignment.position.impl;

import java.util.Objects;

import org.springframework.lang.NonNull;

/**
 * Represents a position with x and y coordinates.
 */
public record Position(@NonNull Coordinate x,
                       @NonNull Coordinate y) {

  public Position {
    Objects.requireNonNull(x);
    Objects.requireNonNull(y);
  }

  /**
   * Checks if this position is equal to another object.
   *
   * @param o The object to compare with this position.
   * @return True if the objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Position position = (Position) o;
    return Objects.equals(x, position.x) && Objects.equals(y, position.y);
  }

  /**
   * Generates a hash code for this position.
   *
   * @return The hash code for this position.
   */
  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}
