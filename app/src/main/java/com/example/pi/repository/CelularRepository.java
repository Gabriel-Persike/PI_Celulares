package com.example.pi.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.example.pi.DAO.CelularDAO;
import com.example.pi.DAO.MarcaDAO;
import com.example.pi.DATABASE.CelularRoomDatabase;
import com.example.pi.Model.Celular;

import java.util.List;

public class CelularRepository {
    private CelularDAO mCelularDAO;
    private List<Celular> mCelulares;
    private List<CelularDAO.CelularJoin> mCelularJoin;

    public CelularRepository(Context context){
        CelularRoomDatabase db = CelularRoomDatabase.getDatabase(context);
        mCelularDAO = db.celularDAO();
    }

    public List<Celular> getAllCelular(){
        mCelulares = mCelularDAO.getCelular();
        return  mCelulares;
    }

    public List<CelularDAO.CelularJoin> getmCelularJoin(){
        mCelularJoin = mCelularDAO.getCelularJoin();
        return mCelularJoin;
    }

    public CelularDAO.CelularJoin getCelularJoinById(int id){
        return mCelularDAO.getCelularJoinById(id);
    }

    public Celular getCelularById(int id){
        return mCelularDAO.getCelularById(id);
    }

    public void insert(Celular celular){
        mCelularDAO.insert(celular);
    }

    public void delete(Celular celular){mCelularDAO.delete(celular);}

    public void update(Celular celular){
        mCelularDAO.update(celular);
    }

    private static class insertAsyncTask extends AsyncTask<Celular,Void,Void>{

        private CelularDAO mAsyncTaskDAO;

        insertAsyncTask(CelularDAO dao){
            mAsyncTaskDAO = dao;
        }

        @Override
        protected Void doInBackground(final Celular... params){
            mAsyncTaskDAO.insert(params[0]);
            return null;
        }
    }

}
