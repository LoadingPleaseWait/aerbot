<<<<<<< HEAD
/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.bellaire.aerbot;


=======
package com.bellaire.aerbot;

>>>>>>> 8923f3db1cde4d20961d549b73fc5d68b95861e5
import com.bellaire.aerbot.controllers.AutonomousController;
import com.bellaire.aerbot.controllers.OperatorController;
import edu.wpi.first.wpilibj.IterativeRobot;

public class Aerbot extends IterativeRobot {
<<<<<<< HEAD
    
    private Environment environment;
    private Executer exec;
    
    private AutonomousController autonomous;
    private OperatorController operator;
    
=======

    private Environment environment;
    private Executer exec;

    private AutonomousController autonomous;
    private OperatorController operator;

>>>>>>> 8923f3db1cde4d20961d549b73fc5d68b95861e5
    public void robotInit() {
        this.environment = new Environment(this);
        this.exec = new Executer(environment);
    }
<<<<<<< HEAD
    
    public void autonomousInit() {
        exec.onAutonomous();
    }

    public void autonomousPeriodic() {

    }
    
=======

    public void disabledInit() {

    }

    public void disabledPeriodic() {

    }

    public void autonomousInit() {
        exec.onAutonomous();
        autonomous = new AutonomousController(environment, exec);
    }

    public void autonomousPeriodic() {
        autonomous.update();
    }

>>>>>>> 8923f3db1cde4d20961d549b73fc5d68b95861e5
    public void teleopInit() {
        exec.onTeleop();
        operator = new OperatorController(environment, exec);
    }

    public void teleopPeriodic() {
        operator.update();
    }
<<<<<<< HEAD
    
    public void testPeriodic() {
    
=======

    public void testPeriodic() {

>>>>>>> 8923f3db1cde4d20961d549b73fc5d68b95861e5
    }
    
}
