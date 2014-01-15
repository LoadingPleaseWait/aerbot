package com.bellaire.aerbot.input;

import edu.wpi.first.wpilibj.Joystick;

public class JoystickInput implements InputMethod {
    
    private Joystick left, right;
    
    public JoystickInput() {
        left = new Joystick(1);
        right = new Joystick(2);
    }

    public double getLeftValue() {
        return left.getY();
    }

    public double getRightValue() {
        return right.getY();
    }
    
}
