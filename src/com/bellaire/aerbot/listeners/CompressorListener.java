
package com.bellaire.aerbot.listeners;

import com.bellaire.aerbot.Environment;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;


public class CompressorListener implements Listener{
    
    private Environment environement;
    private Relay relay;
    private DigitalInput digitalInput;

    public void init(Environment env) {
        environement = env;
        relay = new Relay(1);
        digitalInput = new DigitalInput(1);
    }

    public boolean isComplete() {
        return false;
    }

    public boolean shouldExecute() {
        return true;
    }

    public void execute() {
        if(digitalInput.get())
            relay.set(Relay.Value.kForward);
        else
            relay.set(Relay.Value.kReverse);
    }
    
}
