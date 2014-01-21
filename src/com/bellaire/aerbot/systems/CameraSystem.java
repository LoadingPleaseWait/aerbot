<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bellaire.aerbot.systems;

/**
 *
 * @author Agro
 */
public class CameraSystem implements RobotSystem {

    public void init() {
        
=======
package com.bellaire.aerbot.systems;

import com.bellaire.aerbot.Environment;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CameraSystem implements RobotSystem {
    
    private AxisCamera camera;
    private CameraOps ops;

    public void init(Environment e) {
        camera = AxisCamera.getInstance();
        ops = new CameraOps();
>>>>>>> 8923f3db1cde4d20961d549b73fc5d68b95861e5
    }

    public void destroy() {
        
    }
<<<<<<< HEAD
    
=======

    public boolean foundTarget() {
        ColorImage snapshot = null;
        try {
            snapshot = camera.getImage();
        } catch (AxisCameraException ex) {
            ex.printStackTrace();
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }
        
        if(snapshot == null) {
            SmartDashboard.putString("Camera Snapshot Retrieval", "disfunctional");
            return false;
        }
        
        SmartDashboard.putString("Camera Snapshot Retrieval", "functional");
        try {
            return ops.particleFilter(ops.greenThreshold(snapshot)).getNumberParticles() > 0;
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }
        return false;
    }

>>>>>>> 8923f3db1cde4d20961d549b73fc5d68b95861e5
}
