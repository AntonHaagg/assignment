package com.example.assignment.api.request;

public record NavigationRequest(int width, int height, int x, int y, char orientation, String commands) {
}
