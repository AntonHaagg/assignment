package com.example.assignment.exception;

/**
 * Custom exception class to indicate that the position is invalid.
 */
public class InvalidOrientationException extends RuntimeException {
  public InvalidOrientationException(String message) {
    super(message);
  }
}
