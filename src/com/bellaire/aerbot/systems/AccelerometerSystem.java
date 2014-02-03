/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bellaire.aerbot.systems;

import com.bellaire.aerbot.Environment;
import edu.wpi.first.wpilibj.Accelerometer;

/**
 *
 * @author cmurphey100
 */
public class AccelerometerSystem implements RobotSystem {

    private Accelerometer accelerometer;
    private Environment env;
    private double speed;
    private long lastTime;
    private Thread updater;

    private class SpeedUpdater implements Runnable {

        public void run() {
            lastTime = System.currentTimeMillis();
            while (true) {
                if (System.currentTimeMillis() - lastTime > 0) {
                    speed += accelerometer.getAcceleration() * (System.currentTimeMillis() - lastTime);
                    lastTime = System.currentTimeMillis();
                }
            }

        }
    }

    public void init(Environment e) {
        env = e;
        accelerometer = new Accelerometer(3);
        updater = new Thread(new SpeedUpdater());
        updater.run();
    }

    public void destroy() {
        accelerometer.free();
    }

    public double getSpeed() {
        return speed;
    }

}
