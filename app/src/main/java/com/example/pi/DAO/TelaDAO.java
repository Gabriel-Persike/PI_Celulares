package com.example.pi.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.pi.Model.TELA;

import java.util.List;

@Dao
public interface TelaDAO {
    @Insert
    void insert(TELA tela);

    @Update
    void update(TELA tela);

    @Delete
    void delete(TELA tela);

    @Query("SELECT * FROM TELA")
    List<TELA> getTELA();

    @Query("SELECT * FROM TELA WHERE IDTELA = :id")
    TELA getTELAById(int id);
}
