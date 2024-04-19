package com.example.assignment.robot.impl;

import java.util.Objects;

import org.springframework.lang.NonNull;

import com.example.assignment.position.impl.Orientation;
import com.example.assignment.position.impl.Position;

public record RobotState(@NonNull Position position,
                         @NonNull Orientation orientation) {
  public RobotState {
    Objects.requireNonNull(position);
    Objects.requireNonNull(orientation);
  }
}