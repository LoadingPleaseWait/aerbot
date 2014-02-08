/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bellaire.aerbot.listeners;

import com.bellaire.aerbot.Environment;
import edu.wpi.first.wpilibj.DigitalInput;

public class CompressorListener implements Listener{

    private DigitalInput digitalinput;
    
    public void init(Environment env) {
        digitalinput = new DigitalInput(3);
    }

    public boolean isComplete() {
        return false;
    }

    public boolean shouldExecute() {
        return true;
    }

    public void execute() {
        if(digitalinput.get()){
            
        }else{
            
        }
    }
    
}
