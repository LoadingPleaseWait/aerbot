package com.bellaire.aerbot.listeners;

import com.bellaire.aerbot.Environment;


public class MovementListener implements Listener {

    private Environment env;

    public void init(Environment env) {
        this.env = env;
    }

    public boolean isComplete() {
        return false;
    }

    public boolean shouldExecute() {
        return env.isOperatorControl();
    }

    public void execute() {
        env.getWheelSystem().move(env.getInput());
        //env.getIntakeSystem().intake(env.getInput());
        env.getShooterSystem().fire(env.getInput());
    }
    
}
