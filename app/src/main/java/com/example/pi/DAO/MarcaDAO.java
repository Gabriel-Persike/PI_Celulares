package com.example.pi.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
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

    @Delete
    void delete(Marca marca);

    @Query("SELECT * FROM MARCA_CELULAR WHERE MARCA_CELULAR.IDMARCA_CELULAR == :id")
    Marca getMarcaById(int id);

    @Query("SELECT * FROM MARCA_CELULAR")
    List<Marca> getMarca();
}
