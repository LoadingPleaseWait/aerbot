package com.bellaire.aerbot;

import com.bellaire.aerbot.input.InputMethod;
import com.bellaire.aerbot.input.JoystickInput;
import com.bellaire.aerbot.input.Xbox360Input;
import com.bellaire.aerbot.systems.CameraSystem;
import com.bellaire.aerbot.systems.WheelSystem;
import edu.wpi.first.wpilibj.RobotBase;

public class Environment {

  private RobotBase robot;

  private InputMethod input;

  private WheelSystem wheels;

  private CameraSystem camera;

  public Environment(RobotBase robot) {
    this.robot = robot;
    this.input = new Xbox360Input();
    this.wheels = new WheelSystem();
    this.camera = new CameraSystem();

    camera.init();
    wheels.init();
  }

  public InputMethod getInput() {
    return input;
  }

  public WheelSystem getWheelSystem() {
    return wheels;
  }

  public CameraSystem getCameraSystem() {
    return camera;
  }
  public boolean isAutonomous() {
    return robot.isAutonomous();
  }

  public boolean isOperatorControl() {
    return robot.isOperatorControl();
  }
}