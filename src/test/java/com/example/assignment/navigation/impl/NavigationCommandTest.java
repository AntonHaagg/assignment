package com.example.assignment.navigation.impl;

import com.example.assignment.exception.InvalidNavigationCommandException;
import com.example.assignment.navigation.impl.NavigationCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NavigationCommandTest {

  @Test
  void testGetValue() {
    assertEquals('L', NavigationCommand.LEFT.getValue());
    assertEquals('R', NavigationCommand.RIGHT.getValue());
    assertEquals('F', NavigationCommand.FORWARD.getValue());
  }

  @Test
  void testGetNavigationCommand_Valid() {
    assertEquals(NavigationCommand.LEFT, NavigationCommand.getNavigationCommand('L'));
    assertEquals(NavigationCommand.RIGHT, NavigationCommand.getNavigationCommand('R'));
    assertEquals(NavigationCommand.FORWARD, NavigationCommand.getNavigationCommand('F'));
  }

  @Test
  void testGetNavigationCommand_Invalid() {
    // Test invalid character
    assertThrows(InvalidNavigationCommandException.class, () -> NavigationCommand.getNavigationCommand('X'));
  }
}
