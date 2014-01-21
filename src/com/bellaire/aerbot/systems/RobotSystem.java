package com.bellaire.aerbot.systems;

<<<<<<< HEAD
public interface RobotSystem {
    
    public void init();
    
    public void destroy();
    
=======
import com.bellaire.aerbot.Environment;

public interface RobotSystem {  
  public void init(Environment e); 
  public void destroy();
>>>>>>> 8923f3db1cde4d20961d549b73fc5d68b95861e5
}
