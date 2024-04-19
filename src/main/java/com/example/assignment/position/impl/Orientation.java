package com.example.assignment.position.impl;

import java.util.HashMap;
import java.util.Map;

import com.example.assignment.exception.InvalidNavigationCommandException;

public enum Orientation {
  NORTH('N'),
  EAST('E'),
  SOUTH('S'),
  WEST('W');

  private final char value;

  private static final Map<Character, Orientation> map = new HashMap<>();

  static {
    for (Orientation orientation : Orientation.values()) {
      map.put(orientation.getValue(), orientation);
    }
  }

  Orientation(char value) {
    this.value = value;
  }

  public char getValue() {
    return value;
  }

  /**
   * Returns the Orientation enum value corresponding to the given character.
   *
   * @param character The character representing the Orientation.
   * @return The Orientation enum value.
   * @throws IllegalArgumentException If the character does not correspond to a valid Orientation.
   */
  public static Orientation getOrientation(char character) {
    Orientation command = map.get(character);
    if (command == null) {
      throw new InvalidNavigationCommandException("Invalid navigation command: " + character);
    }
    return command;
  }
}
