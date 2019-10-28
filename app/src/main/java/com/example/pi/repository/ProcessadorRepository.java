package com.example.pi.repository;

import android.content.Context;

import com.example.pi.DAO.ProcessadorDAO;
import com.example.pi.DATABASE.CelularRoomDatabase;
import com.example.pi.Model.PROCESSADOR;

import java.util.List;

public class ProcessadorRepository {
    private ProcessadorDAO processadorDAO;
    private List<PROCESSADOR> mProcessadores;

    public ProcessadorRepository(Context context){
        CelularRoomDatabase db = CelularRoomDatabase.getDatabase(context);
        processadorDAO = db.processadorDAO();
    }

    public List<PROCESSADOR> getProcessadores(){
        mProcessadores = processadorDAO.getProcessadores();
        return mProcessadores;
    }

    public PROCESSADOR getProcessadorById(int id){
        return processadorDAO.getProcessadorById((id));
    }

    public void insert(PROCESSADOR processador){
        processadorDAO.insert(processador);
    }

    public void update(PROCESSADOR processador){
        processadorDAO.update(processador);
    }
}
