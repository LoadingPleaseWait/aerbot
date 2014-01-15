package com.bellaire.aerbot;

import edu.wpi.first.wpilibj.RobotDrive;

public class WheelSystem implements RobotSystem {

    private RobotDrive wheels;
    
    public void init() {
        wheels = new RobotDrive(1, 3);
        
        wheels.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        wheels.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
    }

    public void destroy() {
        
    }
    
    public void move(Input input) {
        wheels.tankDrive(input.getLeftJoystick(), input.getRightJoystick());
    }
    
}
