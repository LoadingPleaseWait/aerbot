package com.bellaire.aerbot;

public class Executer {
    
    private Listener[] listeners;
    
    public Executer(Environment e) {
        listeners = new Listener[1];
        listeners[0] = new MovementListener();
        
        for(int i = 0; i < listeners.length; i++) {
            listeners[i].init(e);
        }
    }
    
    public void update() {
        for(int i = 0; i < listeners.length; i++) {
            Listener l = listeners[i];
            if(l.isListening() && l.shouldExecute()) {
                l.execute();
            }
        }
    }
    
    public void onTeleop() {
        
    }
    
    public void onAutonomous() {
        
    }
    
}
