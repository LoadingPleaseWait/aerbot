package com.bellaire.aerbot.systems;

import com.bellaire.aerbot.Environment;
import com.bellaire.aerbot.input.InputMethod;
import edu.wpi.first.wpilibj.RobotDrive;

public class WheelSystem implements RobotSystem {

  private RobotDrive wheels;

  public void init(Environment e) {
    wheels = new RobotDrive(1, 2); // (1, 2, 3, 4) when unsplit

    wheels.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
    wheels.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
    wheels.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
    wheels.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);

    wheels.setSafetyEnabled(false);
    
    // this.gyro.reset();
  }

  public void destroy() {

  }

  public void setMotors(double left, double right) {
    wheels.setLeftRightMotorOutputs(left, right);
  }

  public void move(InputMethod input) {
    wheels.arcadeDrive(input.getLeftY(), input.getRightX());
    //wheels.drive(-1.0, -gyro.getHeading() * 0.05);
  }
}