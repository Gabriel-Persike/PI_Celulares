package com.example.pi.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Embedded;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.pi.Model.CAMERA;
import com.example.pi.Model.Celular;
import com.example.pi.Model.Marca;
import com.example.pi.Model.Notas;
import com.example.pi.Model.PROCESSADOR;
import com.example.pi.Model.SISTEMA_OPERACIONAL;
import com.example.pi.Model.TELA;

import java.util.List;
@Dao
public interface CelularDAO {
    @Insert
    void insert(Celular celular);

    @Update
    void update(Celular celular);

    @Delete
    void delete(Celular celular);

    @Query("SELECT * FROM MODELO_CELULAR WHERE MODELO_CELULAR.IDMODELO_CELULAR == :id")
    Celular getCelularById(int id);

    @Query("SELECT * FROM MODELO_CELULAR")
    List<Celular> getCelular();

    @Query("SELECT * FROM MODELO_CELULAR INNER JOIN MARCA_CELULAR ON MODELO_CELULAR.MARCA_CELULAR_IDMARCA_CELULAR = MARCA_CELULAR.IDMARCA_CELULAR INNER JOIN CAMERA ON MODELO_CELULAR.CAMERA_IDCAMERA = CAMERA.IDCAMERA INNER JOIN PROCESSADOR ON MODELO_CELULAR.PROCESSADOR_IDPROCESSADOR = PROCESSADOR.IDPROCESSADOR INNER JOIN SISTEMA_OPERACIONAL ON MODELO_CELULAR.SISTEMA_OPERACIONAL_IDSISTEMA_OPERACIONAL = SISTEMA_OPERACIONAL.IDSISTEMA_OPERACIONAL INNER JOIN TELA ON MODELO_CELULAR.TELA_IDTELA = TELA.IDTELA  INNER JOIN Notas_celular on MODELO_CELULAR.NOTAS_IDNOTAS = Notas_celular.IDNOTAS")
    List<CelularJoin> getCelularJoin();

    @Query("SELECT * FROM MODELO_CELULAR INNER JOIN MARCA_CELULAR ON MODELO_CELULAR.MARCA_CELULAR_IDMARCA_CELULAR = MARCA_CELULAR.IDMARCA_CELULAR INNER JOIN CAMERA ON MODELO_CELULAR.CAMERA_IDCAMERA = CAMERA.IDCAMERA INNER JOIN PROCESSADOR ON MODELO_CELULAR.PROCESSADOR_IDPROCESSADOR = PROCESSADOR.IDPROCESSADOR INNER JOIN SISTEMA_OPERACIONAL ON MODELO_CELULAR.SISTEMA_OPERACIONAL_IDSISTEMA_OPERACIONAL = SISTEMA_OPERACIONAL.IDSISTEMA_OPERACIONAL INNER JOIN TELA ON MODELO_CELULAR.TELA_IDTELA = TELA.IDTELA INNER JOIN Notas_celular on MODELO_CELULAR.NOTAS_IDNOTAS = Notas_celular.IDNOTAS WHERE MODELO_CELULAR.IDMODELO_CELULAR = :id")
    CelularJoin getCelularJoinById(int id);

    static class CelularJoin{
        @Embedded
        public Celular celular;
        @Embedded
        public SISTEMA_OPERACIONAL so;
        @Embedded
        public Marca marca;
        @Embedded
        public CAMERA camera;
        @Embedded
        public PROCESSADOR processador;
        @Embedded
        public TELA tela;
        @Embedded
        public Notas notas;
    }
}
