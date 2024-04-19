 package com.example.assignment.grid.impl;

 import java.util.HashMap;
 import java.util.Map;
 import java.util.stream.IntStream;

 import com.example.assignment.exception.InvalidPositionException;
 import com.example.assignment.position.impl.Coordinate;
 import com.example.assignment.position.impl.Position;

 /**
  * Represents the grid structure of the room.
  */
 public class Grid {
   private int width;
   private int height;
   private Map<Position, GridCell> cells;

   /**
    * Constructs a new Grid object with the specified width and height.
    *
    * @param width  The width of the grid.
    * @param height The height of the grid.
    */
   public Grid(int width, int height) {
     this.width = width;
     this.height = height;
     cells = new HashMap<>();
     initializeCells();
   }

   /**
    * Initializes the grid cells, setting the inner region to TILE and the border to VOID.
    */
   private void initializeCells() {
     setInnerRegionToTile();
     setBorderToVoid();
   }

   /**
    * Sets the inner region of the grid to TILE.
    */
   private void setInnerRegionToTile() {
     IntStream.range(0, width)
       .boxed()
       .flatMap(x -> IntStream.range(0, height)
         .mapToObj(y -> new Position(new Coordinate(x), new Coordinate(y))))
       .forEach(position -> cells.put(position, new GridCell(CellType.TILE)));
   }

   /**
    * Sets the border of the grid to VOID.
    */
   private void setBorderToVoid() {
     IntStream.range(-1, width + 1)
       .boxed()
       .flatMap(x -> IntStream.range(-1, height + 1)
         .mapToObj(y -> new Position(new Coordinate(x), new Coordinate(y))))
       .filter(position -> !isInsideBorder(position.x(), position.y()))
       .forEach(position -> cells.put(position, new GridCell(CellType.VOID)));
   }

   /**
    * Checks if the given position is inside the border of the grid.
    *
    * @param x The x-coordinate of the position.
    * @param y The y-coordinate of the position.
    * @return true if the position is inside the border, false otherwise.
    */
   private boolean isInsideBorder(Coordinate x, Coordinate y) {
     return x.getValue() >= 0 && x.getValue() < width && y.getValue() >= 0 && y.getValue() < height;
   }

   /**
    * Retrieves the grid cell at the specified position.
    *
    * @param x The x-coordinate of the position.
    * @param y The y-coordinate of the position.
    * @return The grid cell at the specified position, or null if no cell exists at that position.
    */
   public GridCell getCell(Position position) {
     return cells.getOrDefault(position, null);
   }

   /**
    * Sets the cell type at the specified position.
    *
    * @param x    The x-coordinate of the position.
    * @param y    The y-coordinate of the position.
    * @param type The cell type to set.
    * @throws InvalidPositionException If the position is invalid.
    */
   public void setCell(Position position, CellType type) {
     if (cells.containsKey(position)) {
       cells.get(position).setType(type);
     } else {
       throw new InvalidPositionException("Invalid position");
     }
   }
 }
