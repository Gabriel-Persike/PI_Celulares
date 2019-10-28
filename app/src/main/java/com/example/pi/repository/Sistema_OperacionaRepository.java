package com.example.pi.repository;

import android.content.Context;

import com.example.pi.DAO.Sistema_OperacionalDAO;
import com.example.pi.DATABASE.CelularRoomDatabase;
import com.example.pi.Model.SISTEMA_OPERACIONAL;

import java.util.List;

public class Sistema_OperacionaRepository {
    private Sistema_OperacionalDAO SODAO;
    private List<SISTEMA_OPERACIONAL> SO;

    public Sistema_OperacionaRepository(Context context){
        CelularRoomDatabase db = CelularRoomDatabase.getDatabase(context);
        SODAO = db.sistema_operacionalDAO();
    }

    public List<SISTEMA_OPERACIONAL> getSistema_Operacional(){
        SO = SODAO.getSistema_Operacional();
        return SO;
    }

    public SISTEMA_OPERACIONAL getSistema_OperacionalById(int id){
        return SODAO.getSistema_OperacionalById(id);
    }

    public void insert(SISTEMA_OPERACIONAL so){SODAO.insert(so);}

    public void update(SISTEMA_OPERACIONAL so){SODAO.update(so);}
}
