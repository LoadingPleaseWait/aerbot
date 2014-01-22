package com.bellaire.aerbot.systems;

import com.bellaire.aerbot.Environment;
import com.bellaire.aerbot.input.InputMethod;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class WheelSystem implements RobotSystem {

  private RobotDrive wheels;
  private GyroSystem gyro;

  public void init(Environment e) {
    wheels = new RobotDrive(1, 2); // (1, 2, 3, 4) when unsplit

    wheels.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
    wheels.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
    wheels.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
    wheels.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);

    wheels.setSafetyEnabled(false);
    
    this.gyro = e.getGyroSystem();
  }

  public void destroy() {

  }

  public void setMotors(double left, double right) {
    wheels.setLeftRightMotorOutputs(left, right);
  }
  
  public void drive(double outputMaginitude, double curve) {
      wheels.drive(outputMaginitude, curve);
  }

  public void move(InputMethod input) {
    wheels.arcadeDrive(input.getLeftY(), input.getRightX());
    SmartDashboard.putNumber("Gyro Heading", gyro.getHeading());
    //wheels.drive(-1.0, -gyro.getHeading() * 0.05);
  }
}
