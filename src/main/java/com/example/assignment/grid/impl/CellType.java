package com.example.assignment.grid.impl;

/**
 * Represents the type of a grid cell.
 */
public enum CellType {
    TILE,
    VOID;

    public boolean is(CellType type) {
        return this == type;
    }
}
