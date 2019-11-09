package com.example.pi.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.pi.Model.Notas;

@Dao
public interface NotasDAO {
    @Insert
    long insert(Notas notas);

    @Update
    void update(Notas notas);

    @Delete
    void delete(Notas notas);

    @Query("SELECT * FROM Notas_celular WHERE IDNOTAS = :id")
    Notas getNotasById(int id);
}
