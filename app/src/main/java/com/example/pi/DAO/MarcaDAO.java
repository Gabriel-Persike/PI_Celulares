package com.example.pi.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.pi.Model.Marca;

import java.util.List;
@Dao
public interface MarcaDAO {
    @Insert
    void insert(Marca marca);

    @Update
    void update(Marca marca);

    @Query("SELECT * FROM TMARCA WHERE TMARCA.id == :id")
    Marca getMarcaById(int id);

    @Query("SELECT * FROM tmarca")
    List<Marca> getMarca();
}
