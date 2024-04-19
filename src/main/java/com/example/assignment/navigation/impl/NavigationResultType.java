package com.example.assignment.navigation.impl;

/**
 * Represents the type of a grid cell.
 */
public enum NavigationResultType {
    FINISHED,
    ENTERED_VOID,
    INVALID_NAVIGATION_COMMAND;

    public boolean is(NavigationResultType type) {
        return this == type;
    }
}
