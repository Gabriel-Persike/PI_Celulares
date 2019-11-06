package com.example.pi.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.pi.Model.PROCESSADOR;

import java.util.List;

@Dao
public interface ProcessadorDAO {
    @Insert
    void insert(PROCESSADOR processador);

    @Update
    void update(PROCESSADOR processador);

    @Delete
    void delete(PROCESSADOR processador);

    @Query("SELECT * FROM PROCESSADOR")
    List<PROCESSADOR> getProcessadores();

    @Query("SELECT * FROM PROCESSADOR WHERE IDPROCESSADOR = :id")
    PROCESSADOR getProcessadorById(int id);


}
