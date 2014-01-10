package com.bellaire.aerbot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SimpleRobot;

public class Environment {
    
    private SimpleRobot sr;
    
    RobotDrive drive = new RobotDrive(1, 2);
    Joystick left = new Joystick(1);
    Joystick right = new Joystick(2);
    
    Camera camera = new Camera();
    
    public Environment(SimpleRobot sr) {
        this.sr = sr;
    }
    
    public boolean isOperator() {
        return sr.isOperatorControl();
    }
    
    public boolean isAutonomous() {
        return sr.isAutonomous();
    }
    
}
