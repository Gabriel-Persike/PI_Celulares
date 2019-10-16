package com.example.pi.repository;

import android.content.Context;

import com.example.pi.DAO.CelularDAO;
import com.example.pi.DAO.MarcaDAO;
import com.example.pi.DATABASE.CelularRoomDatabase;
import com.example.pi.Model.Celular;

import java.util.List;

public class CelularRepository {
    private CelularDAO mCelularDAO;
    private List<Celular> mCelulares;

    public CelularRepository(Context context){
        CelularRoomDatabase db = CelularRoomDatabase.getDatabase(context);
        mCelularDAO = db.celularDAO();
    }

    public List<Celular> getAllCelular(){
        mCelulares = mCelularDAO.getCelular();
        return  mCelulares;
    }

    public Celular getCelulcarById(int id){
        return mCelularDAO.getCelularById(id);
    }

    public void insert(Celular celular){
        mCelularDAO.insert(celular);
    }

    public void update(Celular celular){
        mCelularDAO.update(celular);
    }

}
