package com.example.assignment.exception;

/**
 * Custom exception class to indicate that the position is invalid.
 */
public class InvalidPositionException extends RuntimeException {
  public InvalidPositionException(String message) {
    super(message);
  }
}
