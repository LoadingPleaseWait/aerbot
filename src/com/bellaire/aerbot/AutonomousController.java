package com.bellaire.aerbot;

import edu.wpi.first.wpilibj.Timer;

public class AutonomousController extends Controller {
    
    public AutonomousController(Environment e) {
        super(e);
    }
    
    public void start() {
        
    }

    public void update() {
       for(int i = 0; i < 4; i++) {
            env.drive.drive(0.5, 0);
            Timer.delay(2);
            env.drive.drive(0, 0.75);
        }
        env.drive.drive(0, 0);
    }
    
    public void end() {
        
    }
    
}
