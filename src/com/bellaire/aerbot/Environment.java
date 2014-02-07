package com.bellaire.aerbot;

import com.bellaire.aerbot.input.InputMethod;
import com.bellaire.aerbot.input.Xbox360Input;
import com.bellaire.aerbot.systems.AccelerometerSystem;
import com.bellaire.aerbot.systems.GyroSystem;
import com.bellaire.aerbot.systems.SonarSystem;
import com.bellaire.aerbot.systems.WheelSystem;
import edu.wpi.first.wpilibj.RobotBase;

public class Environment {
    
    private RobotBase robot;
    
    private InputMethod input;
    
    private WheelSystem wheels;
    
    private SonarSystem sonar;
    //private GyroSystem gyro;
    //private AccelerometerSystem accel;
    
    private Thread motionThread;

    public Environment(RobotBase robot) {
        this.robot = robot;
        
        this.input = new Xbox360Input();
        
        //this.gyro = new GyroSystem();
        //this.gyro.init(this);
        
        //this.accel = new AccelerometerSystem();
        //this.accel.init(this);
        
        this.sonar = new SonarSystem();
        this.sonar.init(this);
        
        this.wheels = new WheelSystem();
        this.wheels.init(this);
        
        //motionThread = new Thread(motion);
        //motionThread.start();
    }
    
    public InputMethod getInput() {
        return input;
    }
    
    public WheelSystem getWheelSystem() {
        return wheels;
    }
    
    public SonarSystem getSonarSystem() {
        return sonar;
    }
    
    /*public GyroSystem getGyroSystem() {
        return gyro;
    }*/
/*
    public AccelerometerSystem getAccelerometerSystem() {
        return accel;
    }
  */  
    
    public boolean isAutonomous() {
        return robot.isAutonomous();
    }
    
    public boolean isOperatorControl() {
        return robot.isOperatorControl();
    }
    
}