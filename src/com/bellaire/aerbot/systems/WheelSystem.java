package com.bellaire.aerbot.systems;

import com.bellaire.aerbot.Environment;
import com.bellaire.aerbot.input.InputMethod;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class WheelSystem extends PIDSubsystem implements RobotSystem {

    private static final double Kp = 3;
    private static final double Ki = .2;
    private static final double Kd = 0.0;

    private RobotDrive wheels;
    private GyroSystem gyro;
    private SonarSystem sonar;

    public WheelSystem() {
        super(Kp,Ki,Kd);
    }

    public void init(Environment e) {
        wheels = new RobotDrive(1, 2); // (1, 2, 3, 4) when unsplit

        wheels.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        wheels.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        wheels.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        wheels.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);

        wheels.setSafetyEnabled(false);

        this.gyro = e.getGyroSystem();
        sonar = e.getSonarSystem();
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
    
    public void driveToDistance(double distance){
        if (getSetpoint() != distance){
            setSetpoint(distance);
            enable();
        }
    }

    protected double returnPIDInput() {
        return sonar.getRangeInMM();
    }

    protected void usePIDOutput(double d) {
        setMotors(d, -d);
    }

    protected void initDefaultCommand() {
        
    }
}
