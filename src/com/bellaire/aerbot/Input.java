package com.bellaire.aerbot;

import edu.wpi.first.wpilibj.Joystick;

public class Input {
    
    private Joystick left, right;
    
    public Input() {
        left = new Joystick(1);
        right = new Joystick(2);
    }
    
    public Joystick getLeftJoystick() {
        return left;
    }
    
    public Joystick getRightJoystick() {
        return right;
    }
    
}
