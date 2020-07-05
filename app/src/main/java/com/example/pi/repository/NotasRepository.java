package com.example.pi.repository;

import android.content.Context;

import com.example.pi.DAO.NotasDAO;
import com.example.pi.DATABASE.CelularRoomDatabase;
import com.example.pi.Model.Notas;

public class NotasRepository {
    private NotasDAO notasDAO;

    public NotasRepository(Context context){
        CelularRoomDatabase db = CelularRoomDatabase.getDatabase(context);
        notasDAO = db.notasDAO();
    }

    public long insert(Notas notas){return notasDAO.insert(notas);}

    public void update(Notas notas){notasDAO.update(notas);}

    public void delete(Notas notas){notasDAO.delete(notas);}

    public Notas getNotasById(int id){return notasDAO.getNotasById(id);}

}
