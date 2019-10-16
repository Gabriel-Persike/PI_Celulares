package com.example.pi.DATABASE;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.pi.DAO.CelularDAO;
import com.example.pi.DAO.MarcaDAO;
import com.example.pi.Model.Celular;
import com.example.pi.Model.Marca;

@Database(entities = {Celular.class, Marca.class}, version = 1)
public abstract class CelularRoomDatabase extends RoomDatabase {
    private static volatile CelularRoomDatabase INSTANCE;
    public abstract CelularDAO celularDAO();
    public abstract MarcaDAO marcaDAO();

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
