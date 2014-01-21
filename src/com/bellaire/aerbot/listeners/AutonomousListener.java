package com.bellaire.aerbot.listeners;

import com.bellaire.aerbot.Environment;
import com.bellaire.aerbot.systems.CameraSystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonomousListener implements Listener {
    
    private Environment env;
    private CameraSystem camera;
    
    public void init(Environment env) {
        this.env = env;
        
        this.camera = env.getCameraSystem();
        
        SmartDashboard.putNumber("Autonomous Turn Speed", 0.05);
    }

    public boolean isComplete() {
        return env.isOperatorControl();
    }

    public boolean shouldExecute() {
        return env.isAutonomous();
    }

    public void execute() {
        if(!camera.foundTarget()) {
            env.getWheelSystem().drive(SmartDashboard.getNumber("Autonomous Turn Speed", 0.05), 1);
        }
    }
    
}
