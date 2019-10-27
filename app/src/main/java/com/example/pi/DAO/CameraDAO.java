package com.example.pi.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.pi.Model.CAMERA;

import java.util.List;

@Dao
public interface CameraDAO {
    @Insert
    void insert(CAMERA camera);

    @Update
    void update(CAMERA camera);

    @Query("SELECT * FROM CAMERA")
    List<CAMERA> getCAMERAS();

    @Query("SELECT * FROM CAMERA WHERE IDCAMERA = :id")
    CAMERA getCAMERAById(int id);
}
