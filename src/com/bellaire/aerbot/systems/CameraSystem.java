package com.bellaire.aerbot.systems;

import com.bellaire.aerbot.Environment;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// http://wpilib.screenstepslive.com/s/3120/m/8731/l/91395-c-java-code#!prettyPhoto
// http://wpilib.screenstepslive.com/s/3120/m/8731/l/90361-identifying-and-processing-the-targets
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
        boolean detect = false;
        try {
            BinaryImage green = ops.greenThreshold(snapshot);
            BinaryImage pfilter = ops.particleFilter(green);
            detect = pfilter.getNumberParticles() > 0;
            
            pfilter.free();
            green.free();
            snapshot.free();
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }
        return detect;
    }

}
