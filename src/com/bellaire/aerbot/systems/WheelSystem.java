package com.bellaire.aerbot.systems;

import com.bellaire.aerbot.Environment;
import com.bellaire.aerbot.input.InputMethod;
import com.bellaire.aerbot.input.Xbox360Input;
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
        super(Kp, Ki, Kd);
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
        if (input.getButton(Xbox360Input.BUTTON_BACK)) {
            sonar.ping();
        }
    }
    
    public void faceForward(){
        if(gyro.getHeading() < 180)
            setMotors(-.25,.25);
        else
            setMotors(.25, -.25);
    }

    public void driveToDistance(double distance) {
        if (!getPIDController().isEnable()) {
            setSetpoint(distance);
            enable();
        } else if (getPosition() == distance) {
            disable();
        }
    }

    public void selfCatch() {
        if (gyro.getHeading() > 1 && gyro.getHeading() < 358)
            faceForward();
        else if(getPosition() == 0){
            // if getPosition equals the point in front of the truss
            //shoot
            driveToDistance(0);//driveToDistance point behind truss
        }else if(getSetpoint() == 0)
            driveToDistance(0);//drive to point behind the truss
        else if (getSetpoint() != 0 || getSetpoint() == 0) {
            //if setpoint is not the point in front of the truss OR the setpoint is the point in front of the truss
            driveToDistance(0);//drive to point in front of truss
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
