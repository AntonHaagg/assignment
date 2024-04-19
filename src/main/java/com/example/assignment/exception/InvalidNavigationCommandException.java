package com.example.assignment.exception;

/**
 * Custom exception class to indicate that the position is invalid.
 */
public class InvalidNavigationCommandException extends RuntimeException {
  public InvalidNavigationCommandException(String message) {
    super(message);
  }
}
