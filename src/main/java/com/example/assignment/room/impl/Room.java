package com.example.assignment.room.impl;

import org.springframework.lang.NonNull;

import com.example.assignment.grid.impl.CellType;
import com.example.assignment.grid.impl.Grid;
import com.example.assignment.grid.impl.GridCell;
import com.example.assignment.position.impl.Position;

/**
 * Represents a room with a grid structure.
 */
public class Room {
  private Grid grid;

  /**
   * Constructs a new Room with the specified width and height.
   *
   * @param width  The width of the room.
   * @param height The height of the room.
   */
  public Room(int width, int height) {
    grid = new Grid(width, height);
  }

  /**
   * Sets the field type at the specified position in the room.
   *
   * @param position The position to set.
   * @param type     The field type to set.
   */
  public void setFieldTypeAtPosition(Position position, CellType type) {
    grid.setCell(position, type);
  }

  /**
   * Checks if the given position is valid within the grid.
   *
   * @param position The position to validate.
   * @return True if the position is within the grid and not a void cell, false otherwise.
   */
  @NonNull
  public boolean isValidPosition(Position position){
    GridCell cell = grid.getCell(position);
    if(cell == null) {
      return false;
    }

    return !CellType.VOID.is(cell.getType());
  }
}
