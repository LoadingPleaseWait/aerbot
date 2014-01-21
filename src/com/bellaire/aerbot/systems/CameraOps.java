package com.bellaire.aerbot.systems;

import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.CriteriaCollection;
import edu.wpi.first.wpilibj.image.NIVision;
import edu.wpi.first.wpilibj.image.NIVisionException;

public class CameraOps {

    private CriteriaCollection cc;
    
    private final int AREA_MINIMUM = 150;
    
    public CameraOps() {
        cc = new CriteriaCollection();      // create the criteria for the particle filter
        cc.addCriteria(NIVision.MeasurementType.IMAQ_MT_AREA, AREA_MINIMUM, 65535, false);
    }
    
    public BinaryImage greenThreshold(ColorImage image) {
        try {
            return image.thresholdHSV(105, 137, 230, 255, 133, 183);
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public BinaryImage particleFilter(BinaryImage image) {
        try {
            return image.particleFilter(cc);
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
