package com.example.assignment.room.impl;


import com.example.assignment.grid.impl.CellType;
import com.example.assignment.position.impl.Coordinate;
import com.example.assignment.position.impl.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoomTest {

  @Test
  void testIsValidPosition_ValidPosition() {
    // Create a room with dimensions 5x5
    Room room = new Room(5, 5);

    // Set a valid position with a non-void cell type
    Position validPosition = new Position(new Coordinate(2), new Coordinate(3));
    room.setFieldTypeAtPosition(validPosition, CellType.TILE);

    // Check if the position is valid
    assertTrue(room.isValidPosition(validPosition));
  }

  @Test
  void testIsValidPosition_InvalidPosition_OutsideBounds() {
    // Create a room with dimensions 5x5
    Room room = new Room(5, 5);

    // Create an invalid position outside the bounds of the room
    Position invalidPosition = new Position(new Coordinate(6), new Coordinate(2));

    // Check if the position is invalid
    assertFalse(room.isValidPosition(invalidPosition));
  }

  @Test
  void testIsValidPosition_InvalidPosition_VoidCell() {
    // Create a room with dimensions 5x5
    Room room = new Room(5, 5);

    // Set a void cell at the position (3, 3)
    Position voidPosition = new Position(new Coordinate(3), new Coordinate(3));
    room.setFieldTypeAtPosition(voidPosition, CellType.VOID);

    // Check if the position is invalid
    assertFalse(room.isValidPosition(voidPosition));
  }
}
