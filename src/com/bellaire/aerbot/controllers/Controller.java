package com.bellaire.aerbot.controllers;

import com.bellaire.aerbot.Environment;
import com.bellaire.aerbot.Executer;

public abstract class Controller {

<<<<<<< HEAD
    protected Environment env;
    protected Executer exec;
    
    public Controller(Environment env, Executer exec) {
        this.env = env;
        this.exec = exec;
    }
    
    public void update() {
        exec.update();
    }
    
=======
  protected Environment env;
  protected Executer exec;

  public Controller(Environment env, Executer exec) {
    this.env = env;
    this.exec = exec;
  }

  public void update() {
    exec.update();
  }

>>>>>>> 8923f3db1cde4d20961d549b73fc5d68b95861e5
}
