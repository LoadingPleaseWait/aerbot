package com.bellaire.aerbot;

<<<<<<< HEAD
=======
import com.bellaire.aerbot.listeners.AutonomousListener;
>>>>>>> 8923f3db1cde4d20961d549b73fc5d68b95861e5
import com.bellaire.aerbot.listeners.MovementListener;
import com.bellaire.aerbot.listeners.Listener;
import java.util.Vector;

public class Executer {
<<<<<<< HEAD
    
    private final Vector notRunning, running;
    
    public Executer(Environment e) {
        notRunning = new Vector();
        running = new Vector();
        
        MovementListener ml = new MovementListener();
        ml.init(e);
        notRunning.addElement(ml);
    }
    
    public void update() {
        for(int i = 0; i < notRunning.size(); i++) {
            Listener l = (Listener) notRunning.elementAt(i);
            if(l.shouldExecute() && this.canExecute(l)) {
                this.execute(l);
            }
        }
        
        for(int i = 0; i < running.size(); i++) {
            Listener l = (Listener) running.elementAt(i);
            if(l.isComplete()) {
=======

    private final Vector notRunning, running;

    public Executer(Environment e) {
        notRunning = new Vector();
        running = new Vector();

        MovementListener ml = new MovementListener();
        AutonomousListener al = new AutonomousListener();
        
        ml.init(e);
        al.init(e);
        
        notRunning.addElement(ml);
        notRunning.addElement(al);
    }

    public void update() {
        for (int i = 0; i < notRunning.size(); i++) {
            Listener l = (Listener) notRunning.elementAt(i);

            if (l.shouldExecute() && this.canExecute(l)) {
                this.execute(l);
            }
        }

        for (int i = 0; i < running.size(); i++) {
            Listener l = (Listener) running.elementAt(i);

            if (l.isComplete()) {
>>>>>>> 8923f3db1cde4d20961d549b73fc5d68b95861e5
                stop(l);
            } else {
                l.execute();
            }
        }
    }
<<<<<<< HEAD
    
=======

>>>>>>> 8923f3db1cde4d20961d549b73fc5d68b95861e5
    public void execute(Listener listener) {
        running.addElement(listener);
        notRunning.removeElement(listener);
    }
<<<<<<< HEAD
    
    public boolean canExecute(Listener listener) {
        return true;
    }
    
=======

    public boolean canExecute(Listener listener) {
        return true;
    }

>>>>>>> 8923f3db1cde4d20961d549b73fc5d68b95861e5
    public void stop(Listener listener) {
        notRunning.addElement(listener);
        running.removeElement(listener);
    }
<<<<<<< HEAD
    
    public void stopAll() {
        for(int i = 0; i < running.size(); i++) {
=======

    public void stopAll() {
        for (int i = 0; i < running.size(); i++) {
>>>>>>> 8923f3db1cde4d20961d549b73fc5d68b95861e5
            Listener l = (Listener) running.elementAt(i);
            this.stop(l);
        }
    }
<<<<<<< HEAD
    
    public void onTeleop() {
        
    }
    
    public void onAutonomous() {
        
    }
    
=======

    public void onTeleop() {

    }

    public void onAutonomous() {

    }

>>>>>>> 8923f3db1cde4d20961d549b73fc5d68b95861e5
}
