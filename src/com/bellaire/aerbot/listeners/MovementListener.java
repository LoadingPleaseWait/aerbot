<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

=======
>>>>>>> 8923f3db1cde4d20961d549b73fc5d68b95861e5
package com.bellaire.aerbot.listeners;

import com.bellaire.aerbot.Environment;

<<<<<<< HEAD
/**
 *
 * @author Agro
 */
public class MovementListener implements Listener {

    private Environment env;
    
=======
public class MovementListener implements Listener {

    private Environment env;

>>>>>>> 8923f3db1cde4d20961d549b73fc5d68b95861e5
    public void init(Environment env) {
        this.env = env;
    }

    public boolean isComplete() {
<<<<<<< HEAD
        return false;
    }

    public boolean shouldExecute() {
        return true;
=======
        return env.isAutonomous();
    }

    public boolean shouldExecute() {
        return env.isOperatorControl();
>>>>>>> 8923f3db1cde4d20961d549b73fc5d68b95861e5
    }

    public void execute() {
        env.getWheelSystem().move(env.getInput());
    }
    
}
