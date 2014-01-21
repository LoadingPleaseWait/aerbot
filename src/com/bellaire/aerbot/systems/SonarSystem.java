package com.bellaire.aerbot.systems;

<<<<<<< HEAD
/**
 *
 * @author Agro
 */
public class SonarSystem implements RobotSystem {

    public void init() {
       
    }

    public void destroy() {
        
    }
    
}
=======
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
>>>>>>> 8923f3db1cde4d20961d549b73fc5d68b95861e5
