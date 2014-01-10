package com.bellaire.aerbot;

public abstract class Controller implements Sensor {
    
    protected Environment env;
    
    public Controller(Environment e) {
        this.env = e;
    }
    
    public abstract void update();
    
    public boolean enabled() {
        if(env.isAutonomous() && this instanceof AutonomousController) {
            return true;
        } else if(env.isOperator() && this instanceof OperatorController) {
            return true;
        }
        return false;   
    }
    
}
