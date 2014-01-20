package com.bellaire.aerbot;

import com.bellaire.aerbot.controllers.AutonomousController;
import com.bellaire.aerbot.controllers.OperatorController;
import com.bellaire.aerbot.systems.CameraSystem;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.camera.AxisCameraException;

public class Aerbot extends IterativeRobot {

  private Environment environment;
  private Executer exec;

  private AutonomousController autonomous;
  private OperatorController operator;

  public void robotInit() {
    this.environment = new Environment(this);
    this.exec = new Executer(environment);
  }

  public void autonomousInit() {
    exec.onAutonomous();
  }

  public void autonomousPeriodic() {
    double speed;
    double Kp = 1.0;
    CameraSystem camera = environment.getCameraSystem();

    try {
      speed = camera.getXCoordinate() * Kp;
      environment.getWheelSystem().move(speed, speed);

      /*
       if (camera.getDistance() > 10) {
       environment.getWheelSystem().move(1, -1);
       } else if (camera.getDistance() < 5) {
       environment.getWheelSystem().move(1, -1);
       } else {
       environment.getWheelSystem().move(0, 0);
       }
       */
    } catch (NIVisionException e) {
      e.printStackTrace();
    } catch (AxisCameraException ex) {
      ex.printStackTrace();
    }
  }

  public void teleopInit() {
    exec.onTeleop();
    operator = new OperatorController(environment, exec);
  }

  public void teleopPeriodic() {
    operator.update();
  }

  public void testPeriodic() {
    return;
  }
}