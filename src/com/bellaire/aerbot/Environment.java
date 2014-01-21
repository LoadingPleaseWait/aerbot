package com.bellaire.aerbot;

import com.bellaire.aerbot.input.InputMethod;
import com.bellaire.aerbot.input.JoystickInput;
import com.bellaire.aerbot.input.Xbox360Input;
import com.bellaire.aerbot.systems.CameraSystem;
import com.bellaire.aerbot.systems.GyroSystem;
import com.bellaire.aerbot.systems.IntakeSystem;
import com.bellaire.aerbot.systems.WheelSystem;
import edu.wpi.first.wpilibj.RobotBase;

public class Environment {

    private RobotBase robot;

    private InputMethod input;

    private CameraSystem camera;
    private WheelSystem wheels;
    private GyroSystem gyro;
    private IntakeSystem intake;

    public Environment(RobotBase robot) {
        this.robot = robot;

        this.input = new Xbox360Input();

        this.gyro = new GyroSystem();
        this.gyro.init(this);

        this.camera = new CameraSystem();
        this.camera.init(this);

        this.wheels = new WheelSystem();
        this.wheels.init(this);
        
        this.intake = new IntakeSystem();
        this.intake.init(this);
    }

    public InputMethod getInput() {
        return input;
    }

    public WheelSystem getWheelSystem() {
        return wheels;
    }

    public CameraSystem getCameraSystem() {
        return camera;
    }

    public GyroSystem getGyroSystem() {
        return gyro;
    }
    
    public IntakeSystem getIntakeSystem(){
        return intake;
    }

    public boolean isAutonomous() {
        return robot.isAutonomous();
    }

    public boolean isOperatorControl() {
        return robot.isOperatorControl();
    }
}
