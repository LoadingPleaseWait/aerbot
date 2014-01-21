package com.bellaire.aerbot.systems;

import com.bellaire.aerbot.input.InputMethod;
import com.bellaire.aerbot.input.Xbox360Input;
import edu.wpi.first.wpilibj.Jaguar;

public class IntakeSystem implements RobotSystem{

    private Jaguar motor;
    
    public void init(Environment e) {
        motor = new Jaguar(3);
    }

    public void destroy() {
        
    }
    
    public void intake(InputMethod input){
        if (input.getButton(Xbox360Input.BUTTON_X))
            motor.set(1);
        else if (input.getButton(Xbox360Input.BUTTON_B))
            motor.set(-1);
        else
            motor.set(0);
    }
}
