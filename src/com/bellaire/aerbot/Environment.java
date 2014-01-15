package com.bellaire.aerbot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SimpleRobot;

public class Environment {
    
    private SimpleRobot sr;
    
    RobotDrive drive = new RobotDrive(1,3); // switch to (1,2)
    Joystick left = new Joystick(1);
    Joystick right = new Joystick(2);
    
    private Camera camera = new Camera();
    private Sonar sonar = new Sonar();
    
    public Environment(SimpleRobot sr) {
        this.sr = sr;
        
        // kFront* do not refer to any motors.
        drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
    }
    
    public Camera getCamera() {
        return camera;
    }
    
    public Sonar getSonar() {
        return sonar;
    }
    
    public boolean isOperator() {
        return sr.isOperatorControl();
    }
    
    public boolean isAutonomous() {
        return sr.isAutonomous();
    }
    
}
