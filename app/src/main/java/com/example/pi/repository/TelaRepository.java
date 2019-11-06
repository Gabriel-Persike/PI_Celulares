package com.example.pi.repository;

import android.content.Context;

import com.example.pi.DAO.TelaDAO;
import com.example.pi.DATABASE.CelularRoomDatabase;
import com.example.pi.Model.TELA;

import java.util.List;

public class TelaRepository {
    private TelaDAO telaDAO;
    private List<TELA> telas;

    public TelaRepository(Context context){
        CelularRoomDatabase db = CelularRoomDatabase.getDatabase(context);
        telaDAO = db.telaDAO();
    }

    public List<TELA> getTELA(){
        telas = telaDAO.getTELA();
        return telas;
    }

    public TELA getTELAById(int id){
        return telaDAO.getTELAById(id);
    }

    public void insert(TELA tela){telaDAO.insert(tela);}

    public void update(TELA tela){telaDAO.update(tela);}

    public void delete(TELA tela){telaDAO.delete(tela);}
}
