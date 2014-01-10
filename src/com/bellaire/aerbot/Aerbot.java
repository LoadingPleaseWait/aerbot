/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.bellaire.aerbot;


import edu.wpi.first.wpilibj.SimpleRobot;

public class Aerbot extends SimpleRobot {
    
    Environment e = new Environment(this);
    AutonomousController ac = new AutonomousController(e);
    OperatorController oc = new OperatorController(e);
    
    // called when bot switches to auto
    public void autonomous() {
        ac.update();
    }

    // called when bot switched to op
    public void operatorControl() {
        oc.update();
    }
    
    // called on test mode
    public void test() {
    
    }
}
