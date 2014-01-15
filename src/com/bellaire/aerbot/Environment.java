package com.bellaire.aerbot;

import edu.wpi.first.wpilibj.RobotBase;

public class Environment {
    
    private RobotBase robot;
    
    private Input input;
    
    private WheelSystem wheels;

    public Environment(RobotBase robot) {
        this.robot = robot;
        
        this.input = new Input();
        
        this.wheels = new WheelSystem();
        wheels.init();
    }
    
    public Input getInput() {
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
