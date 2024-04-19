package com.example.assignment.navigation.impl;

import java.util.HashMap;
import java.util.Map;

import com.example.assignment.exception.InvalidNavigationCommandException;

/**
 * Enum representing navigation commands (Left, Right, Forward).
 */

public enum NavigationCommand {
  LEFT('L'),
  RIGHT('R'),
  FORWARD('F');

  private final char value;
  private static final Map<Character, NavigationCommand> map = new HashMap<>();

  static {
    for (NavigationCommand command : NavigationCommand.values()) {
      map.put(command.getValue(), command);
    }
  }

  NavigationCommand(char value) {
    this.value = value;
  }

  public char getValue() {
    return value;
  }

  /**
   * Returns the NavigationCommand enum value corresponding to the given character.
   *
   * @param character The character representing the navigation command.
   * @return The NavigationCommand enum value.
   * @throws IllegalArgumentException If the character does not correspond to a valid navigation command.
   */
  public static NavigationCommand getNavigationCommand(char character) {
    NavigationCommand command = map.get(character);
    if (command == null) {
      throw new InvalidNavigationCommandException("Invalid navigation command: " + character);
    }
    return command;
  }
}

