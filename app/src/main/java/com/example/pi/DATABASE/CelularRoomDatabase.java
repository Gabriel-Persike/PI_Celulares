package com.example.pi.DATABASE;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.pi.DAO.CameraDAO;
import com.example.pi.DAO.CelularDAO;
import com.example.pi.DAO.MarcaDAO;
import com.example.pi.DAO.ProcessadorDAO;
import com.example.pi.DAO.Sistema_OperacionalDAO;
import com.example.pi.DAO.TelaDAO;
import com.example.pi.Model.CAMERA;
import com.example.pi.Model.Celular;
import com.example.pi.Model.Marca;
import com.example.pi.Model.PROCESSADOR;
import com.example.pi.Model.SISTEMA_OPERACIONAL;
import com.example.pi.Model.TELA;

@Database(entities = {Celular.class, Marca.class, CAMERA.class, PROCESSADOR.class, SISTEMA_OPERACIONAL.class, TELA.class}, version = 1)
public abstract class CelularRoomDatabase extends RoomDatabase {
    private static volatile CelularRoomDatabase INSTANCE;
    public abstract CelularDAO celularDAO();
    public abstract MarcaDAO marcaDAO();
    public abstract CameraDAO cameraDAO();
    public abstract ProcessadorDAO processadorDAO();
    public abstract Sistema_OperacionalDAO sistema_operacionalDAO();
    public abstract TelaDAO telaDAO();

    public static CelularRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (CelularRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), CelularRoomDatabase.class, "celular_database").allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }
}
