package com.example.assignment.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment.api.request.NavigationRequest;
import com.example.assignment.navigation.impl.NavigationResult;
import com.example.assignment.navigation.impl.RobotRoomNavigator;
import com.example.assignment.position.impl.Coordinate;
import com.example.assignment.position.impl.Orientation;
import com.example.assignment.robot.impl.StandardRobot;
import com.example.assignment.room.impl.Room;

@RestController
@RequestMapping("/api")
public class RobotController {


  public RobotController() {
  }

  @PostMapping("/navigate")
  public ResponseEntity<NavigationResult> navigate(@RequestBody NavigationRequest request) {
    Room room = new Room(request.width(), request.height());
    Orientation orientation = Orientation.getOrientation(request.orientation());
    StandardRobot robot = new StandardRobot(new Coordinate(request.x()),
                                            new Coordinate(request.y()),
                                            orientation);

    RobotRoomNavigator navigator = new RobotRoomNavigator(room, robot);
    NavigationResult result = navigator.executeCommands(request.commands());
    return ResponseEntity.ok(result);
  }
}
