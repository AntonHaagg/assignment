package com.example.assignment.navigation.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.lang.NonNull;

import com.example.assignment.robot.impl.RobotState;

public record NavigationResult(@NonNull List<RobotState> robotStates,
                               @NonNull NavigationResultType navigationResultType) {

  public NavigationResult {
    Objects.requireNonNull(robotStates);
    Objects.requireNonNull(navigationResultType);
  }
}
