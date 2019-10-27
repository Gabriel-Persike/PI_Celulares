package com.example.pi.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.pi.Model.SISTEMA_OPERACIONAL;

import java.util.List;

@Dao
public interface Sistema_OperacionalDAO {
    @Insert
    void insert(SISTEMA_OPERACIONAL sistema_operacional);

    @Update
    void update(SISTEMA_OPERACIONAL sistema_operacional);

    @Query("SELECT * FROM SISTEMA_OPERACIONAL")
    List<SISTEMA_OPERACIONAL> getSistema_Operacional();

    @Query("SELECT * FROM SISTEMA_OPERACIONAL WHERE IDSISTEMA_OPERACIONAL = :id")
    SISTEMA_OPERACIONAL getSistema_OperacionalById(int id);

}
