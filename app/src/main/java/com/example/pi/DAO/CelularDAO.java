package com.example.pi.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.pi.Model.Celular;

import java.util.List;
@Dao
public interface CelularDAO {
    @Insert
    void insert(Celular celular);

    @Update
    void update(Celular celular);

    @Query("SELECT * FROM tcel WHERE tcel.id == :id")
    Celular getCelularById(int id);

    @Query("SELECT * FROM tcel")
    List<Celular> getCelular();
}
