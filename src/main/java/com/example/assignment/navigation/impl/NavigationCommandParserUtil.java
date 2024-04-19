package com.example.assignment.navigation.impl;

import java.util.List;

public class NavigationCommandParserUtil {
  private NavigationCommandParserUtil() {
  }

  /**
   * Parses a string containing navigation commands and returns a list of NavigationCommand objects.
   *
   * @param commandString The string containing navigation commands.
   * @return A list of NavigationCommand objects parsed from the string.
   */
  public static List<NavigationCommand> parseCommands(String commandString) {
    return commandString.chars()
      .mapToObj(command -> (char) command)
      .map(NavigationCommand::getNavigationCommand)
      .toList();
  }
}

