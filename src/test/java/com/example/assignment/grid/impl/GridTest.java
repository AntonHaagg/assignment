package com.example.assignment.grid.impl;

import com.example.assignment.exception.InvalidPositionException;
import com.example.assignment.position.impl.Coordinate;
import com.example.assignment.position.impl.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

  @Test
  void testGetCell_ValidPosition() {
    Grid grid = new Grid(5, 5);
    Position validPosition = new Position(new Coordinate(2), new Coordinate(3));

    // Ensure cell type is initially TILE
    assertEquals(CellType.TILE, grid.getCell(validPosition).getType());

    // Set the cell type to VOID and verify
    grid.setCell(validPosition, CellType.VOID);
    assertEquals(CellType.VOID, grid.getCell(validPosition).getType());
  }

  @Test
  void testGetCell_VoidPosition() {
    Grid grid = new Grid(5, 5);
    Position invalidPosition = new Position(new Coordinate(-1), new Coordinate(3));
    GridCell cell = grid.getCell(invalidPosition);

    // Ensure cell type is VOID
    assertEquals(CellType.VOID, cell.getType());
  }

  @Test
  void testGetCell_InvalidPosition() {
    Grid grid = new Grid(5, 5);
    Position invalidPosition = new Position(new Coordinate(-2), new Coordinate(3));

    // Attempt to retrieve cell at invalid position
    assertNull(grid.getCell(invalidPosition));
  }

  @Test
  void testSetCell_ValidPosition() {
    Grid grid = new Grid(5, 5);
    Position validPosition = new Position(new Coordinate(2), new Coordinate(3));

    // Set the cell type to TILE and verify
    grid.setCell(validPosition, CellType.TILE);
    assertEquals(CellType.TILE, grid.getCell(validPosition).getType());
  }

  @Test
  void testSetCell_InvalidPosition() {
    Grid grid = new Grid(5, 5);
    Position invalidPosition = new Position(new Coordinate(-2), new Coordinate(3));

    // Attempt to set cell type at invalid position
    assertThrows(InvalidPositionException.class, () -> grid.setCell(invalidPosition, CellType.TILE));
  }
}
