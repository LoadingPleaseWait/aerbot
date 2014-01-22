package com.bellaire.aerbot.systems;

import com.bellaire.aerbot.Environment;
import com.bellaire.aerbot.input.InputMethod;
import com.bellaire.aerbot.input.Xbox360Input;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Solenoid;

public class IntakeSystem implements RobotSystem {

    private Jaguar motor;

    private Solenoid arm;

    public void init(Environment e) {
        motor = new Jaguar(3);
        arm = new Solenoid(5);
    }

    public void destroy() {
        motor.free();
        arm.free();
    }

    public void intake(InputMethod input) {
        if (input.getButton(Xbox360Input.BUTTON_X)) {
            motor.set(1);
        } else if (input.getButton(Xbox360Input.BUTTON_B)) {
            motor.set(-1);
        } else {
            motor.set(0);
        }
        if (input.getButton(Xbox360Input.BUTTON_LB)) {
            arm.set(!arm.get());// when LB is pressed pneumatic piston turns on or off
        }
    }
}
