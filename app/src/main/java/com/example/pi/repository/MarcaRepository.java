package com.example.pi.repository;

import android.content.Context;

import com.example.pi.DAO.MarcaDAO;
import com.example.pi.DATABASE.CelularRoomDatabase;
import com.example.pi.Model.Marca;

import java.util.List;

public class MarcaRepository {
    private MarcaDAO mMarcaDAO;
    private List<Marca> mMarcas;

    public MarcaRepository(Context context) {
        CelularRoomDatabase db = CelularRoomDatabase.getDatabase(context);
        mMarcaDAO = db.marcaDAO();
    }

    public List<Marca> getAllMarcas(){
        mMarcas = mMarcaDAO.getMarca();
        return mMarcas;
    }

    public Marca getMarcaById(int id){
        return mMarcaDAO.getMarcaById(id);
    }

    public void insert(Marca marca){
        mMarcaDAO.insert(marca);
    }

    public void update(Marca marca){
        mMarcaDAO.update(marca);
    }

    public void delete(Marca marca) {mMarcaDAO.delete(marca);}
}
