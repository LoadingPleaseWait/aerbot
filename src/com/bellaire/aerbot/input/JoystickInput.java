package com.bellaire.aerbot.input;

import edu.wpi.first.wpilibj.Joystick;

public class JoystickInput implements InputMethod {
<<<<<<< HEAD
    
    private Joystick left, right;
    
    public JoystickInput() {
        left = new Joystick(1);
        right = new Joystick(2);
    }

    public double getLeftY() {
        return left.getY();
    }

    public double getRightY() {
        return right.getY();
    }
    
    public double getLeftX() {
        return left.getY();
    }

    public double getRightX() {
        return right.getY();
    }
    
}
=======
  private Joystick left, right;

  public JoystickInput() {
    left = new Joystick(1);
    right = new Joystick(2);
  }

  public double getLeftY() {
    return left.getY();
  }

  public double getRightY() {
    return right.getY();
  }

  public double getLeftX() {
    return left.getY();
  }

  public double getRightX() {
    return right.getY();
  }
}
>>>>>>> 8923f3db1cde4d20961d549b73fc5d68b95861e5
