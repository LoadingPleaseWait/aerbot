package com.bellaire.aerbot;

import com.bellaire.aerbot.input.InputMethod;
import com.bellaire.aerbot.input.JoystickInput;
import com.bellaire.aerbot.input.Xbox360Input;
<<<<<<< HEAD
=======
import com.bellaire.aerbot.systems.CameraSystem;
import com.bellaire.aerbot.systems.GyroSystem;
>>>>>>> 8923f3db1cde4d20961d549b73fc5d68b95861e5
import com.bellaire.aerbot.systems.WheelSystem;
import edu.wpi.first.wpilibj.RobotBase;

public class Environment {
<<<<<<< HEAD
    
    private RobotBase robot;
    
    private InputMethod input;
    
    private WheelSystem wheels;

    public Environment(RobotBase robot) {
        this.robot = robot;
        
        
        
        this.input = new Xbox360Input();
        
        this.wheels = new WheelSystem();
        wheels.init();
    }
    
    public InputMethod getInput() {
        return input;
    }
    
    public WheelSystem getWheelSystem() {
        return wheels;
    }
    
    public boolean isAutonomous() {
        return robot.isAutonomous();
    }
    
    public boolean isOperatorControl() {
        return robot.isOperatorControl();
    }
    
}
=======

  private RobotBase robot;

  private InputMethod input;

  private CameraSystem camera;
  private WheelSystem wheels;
  private GyroSystem gyro;

  public Environment(RobotBase robot) {
    this.robot = robot;
        
    this.input = new Xbox360Input();
        
    this.gyro = new GyroSystem();
    this.gyro.init(this);
    
    this.camera = new CameraSystem();
    this.camera.init(this);
    
    this.wheels = new WheelSystem();
    this.wheels.init(this);
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
  
  public GyroSystem getGyroSystem() {
      return gyro;
  }
  
  public boolean isAutonomous() {
    return robot.isAutonomous();
  }

  public boolean isOperatorControl() {
    return robot.isOperatorControl();
  }
}
>>>>>>> 8923f3db1cde4d20961d549b73fc5d68b95861e5
