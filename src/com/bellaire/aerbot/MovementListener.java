/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bellaire.aerbot;

/**
 *
 * @author Agro
 */
public class MovementListener implements Listener {

    private Environment env;
    
    public void init(Environment env) {
        this.env = env;
    }

    public boolean isListening() {
        return true;
    }

    public boolean shouldExecute() {
        return true;
    }

    public void execute() {
        env.getWheelSystem().move(env.getInput());
    }
    
}
