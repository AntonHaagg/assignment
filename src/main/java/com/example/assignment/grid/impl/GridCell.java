package com.example.assignment.grid.impl;

/**
 * Represents a single cell in the grid.
 */
public class GridCell {

  /**
   * The type of the cell.
   */
  private CellType type;

  /**
   * Constructs a new GridCell with the specified type.
   *
   * @param type The type of the cell.
   */
  public GridCell(CellType type) {
    this.type = type;
  }

  /**
   * Retrieves the type of the cell.
   *
   * @return The type of the cell.
   */
  public CellType getType() {
    return type;
  }

  /**
   * Sets the type of the cell.
   *
   * @param type The type to set.
   */
  public void setType(CellType type) {
    this.type = type;
  }
}
