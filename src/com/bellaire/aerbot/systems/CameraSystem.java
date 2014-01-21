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
    }

    public void destroy() {
        
    }

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

}
