package com.bellaire.aerbot.systems;

import com.bellaire.aerbot.Environment;
import edu.wpi.first.wpilibj.Ultrasonic;

public class SonarSystem implements RobotSystem {

  private Ultrasonic ultrasonic;
  public static int PING_CHANNEL = 0, ECHO_CHANNEL = 0;// change to the current channels on the bot

  public void init(Environment e) {
    ultrasonic = new Ultrasonic(PING_CHANNEL, ECHO_CHANNEL);
  }

  public void destroy() {
    ultrasonic.free();
  }

  public double getRangeInInches() {
    return ultrasonic.getRangeInches();
  }

  public double getRangeInMM() {
    return ultrasonic.getRangeMM();
  }

  public void ping() {
    ultrasonic.ping();
  }
}