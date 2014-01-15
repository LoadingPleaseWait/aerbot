package com.bellaire.aerbot.input;

import edu.wpi.first.wpilibj.Joystick;

public class Xbox360Input implements InputMethod {

    private Joystick controller;
    
    public Xbox360Input() {
        controller = new Joystick(1);
    }
    
    public double getLeftValue() {
        return controller.getRawAxis(2);
    }

    public double getRightValue() {
        return controller.getRawAxis(5);
    }
    
}
