package com.bellaire.aerbot;

import edu.wpi.first.wpilibj.Timer;

public class OperatorController extends Controller {
    
    public OperatorController(Environment e) {
        super(e);
    }
    
    public void start() {
        
    }
    
    public void update() {
       env.drive.setSafetyEnabled(true);
       while(env.isOperator()) {
           env.drive.tankDrive(env.left, env.right);
           Timer.delay(0.01);
       }
    }
    
    public void end() {
        
    }
    
}
