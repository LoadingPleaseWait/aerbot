package com.bellaire.aerbot;

public abstract class Controller implements Sensor {
    
    protected Environment env;
    
    public Controller(Environment e) {
        this.env = e;
    }
    
}
