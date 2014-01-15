package com.bellaire.aerbot.systems;

import com.bellaire.aerbot.input.InputMethod;
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
    
    // adjusts value for deadzone
    public double adjust(double d) {
        if(d > 0.15)
            return d;
        return 0;
    }
    
    public void move(InputMethod input) {
        //wheels.tankDrive(input.getLeftJoystick(), input.getRightJoystick());
        wheels.tankDrive(input.getLeftValue(), input.getRightValue());
    }
    
}
