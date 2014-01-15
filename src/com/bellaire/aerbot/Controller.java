package com.bellaire.aerbot;

public abstract class Controller {

    protected Environment env;
    protected Executer exec;
    
    public Controller(Environment env, Executer exec) {
        this.env = env;
        this.exec = exec;
    }
    
    public void update() {
        exec.update();
    }
    
}
