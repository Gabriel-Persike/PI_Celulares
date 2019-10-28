package com.example.pi.repository;

import android.content.Context;

import com.example.pi.DAO.CameraDAO;
import com.example.pi.DATABASE.CelularRoomDatabase;
import com.example.pi.Model.CAMERA;

import java.util.List;

public class CameraRepository {
    private CameraDAO cameraDAO;
    private List<CAMERA> Cameras;

    public CameraRepository(Context context){
        CelularRoomDatabase db = CelularRoomDatabase.getDatabase(context);
        cameraDAO = db.cameraDAO();
    }

    public List<CAMERA> getCameras(){
        Cameras = cameraDAO.getCAMERAS();
        return Cameras;
    }

    public CAMERA getCAMERAById(int id){
        return cameraDAO.getCAMERAById(id);
    }

    public void insert(CAMERA camera){cameraDAO.insert(camera);}

    public void update(CAMERA camera){cameraDAO.update(camera);}

}
