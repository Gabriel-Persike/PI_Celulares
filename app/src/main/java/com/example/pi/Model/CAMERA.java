package com.example.pi.Model;

import androidx.room.Entity;

@Entity(tableName = "CAMERA")
public class CAMERA {
    private int IDCAMERA;
    private String CAMERA_TRASEIRA;
    private String CAMERA_FRONTAL;

    public CAMERA(int IDCAMERA, String CAMERA_TRASEIRA, String CAMERA_FRONTAL) {
        this.IDCAMERA = IDCAMERA;
        this.CAMERA_TRASEIRA = CAMERA_TRASEIRA;
        this.CAMERA_FRONTAL = CAMERA_FRONTAL;
    }

    public int getIDCAMERA() {
        return IDCAMERA;
    }

    public void setIDCAMERA(int IDCAMERA) {
        this.IDCAMERA = IDCAMERA;
    }

    public String getCAMERA_TRASEIRA() {
        return CAMERA_TRASEIRA;
    }

    public void setCAMERA_TRASEIRA(String CAMERA_TRASEIRA) {
        this.CAMERA_TRASEIRA = CAMERA_TRASEIRA;
    }

    public String getCAMERA_FRONTAL() {
        return CAMERA_FRONTAL;
    }

    public void setCAMERA_FRONTAL(String CAMERA_FRONTAL) {
        this.CAMERA_FRONTAL = CAMERA_FRONTAL;
    }
}
