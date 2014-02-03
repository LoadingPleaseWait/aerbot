package com.bellaire.aerbot.systems;

import com.bellaire.aerbot.Environment;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class ShooterSystem extends PIDSubsystem implements RobotSystem {

    private static final double Kp = 6;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    public static final double LAUNCH_SPEED = 3;
    public static final double GRAVITY = 9.81;
    public static final double GOAL_HEIGHT = 3;
    private Environment env;
    private AnalogChannel pot;
    private Jaguar motors;

    public ShooterSystem() {
        super(Kp, Ki, Kd);
    }

    public void init(Environment e) {
        env = e;
        pot = new AnalogChannel(3);
        motors = new Jaguar(3);
    }

    public void destroy() {
        pot.free();
        motors.free();
    }

    public void shoot(double distance) {
        double angle = 0;
        setSetpoint(0.0);
        enable();
    }

    protected double returnPIDInput() {
        return pot.getVoltage();
    }

    protected void usePIDOutput(double d) {
        motors.set(d);
    }

    protected void initDefaultCommand() {

    }

}
