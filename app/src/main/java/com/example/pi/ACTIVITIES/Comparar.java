package com.example.pi.ACTIVITIES;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.pi.Adapter.CelularAdapter;
import com.example.pi.DAO.CelularDAO;
import com.example.pi.R;
import com.example.pi.repository.Repository;

import java.util.List;

public class Comparar extends Activity implements AdapterView.OnItemClickListener {

    Repository repository;
    ArrayAdapter<CelularDAO.CelularJoin> adapter;
    ListView listCelulares;
    private CelularDAO.CelularJoin celular1;
    private CelularDAO.CelularJoin celular2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparar);
        int id = getIntent().getIntExtra("ID", 0);
        repository = new Repository(getApplicationContext());
        listCelulares = findViewById(R.id.listCelularesComparar);
        listCelulares.setOnItemClickListener(this);
        celular1 = repository.getCelularRepository().getCelularJoinById(id);
        celular2 = new CelularDAO.CelularJoin();
        loadCelular();
    }


    public void loadCelular(){
        List<CelularDAO.CelularJoin> celulares = repository.getCelularRepository().getmCelularJoin();
        adapter = new CelularAdapter(getApplicationContext(), R.layout.celular_item, celulares);
        listCelulares.setAdapter(adapter);
    }

    public void callActivityComparacao(int id1, int id2){
        Intent comparar = new Intent(Comparar.this,Comparacao.class);
        comparar.putExtra("ID1",id1);
        comparar.putExtra("ID2",id2);
        startActivity(comparar);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
       celular2 = (CelularDAO.CelularJoin) adapterView.getItemAtPosition(i);
        callActivityComparacao(celular1.celular.getIDMODELO_CELULAR(), celular2.celular.getIDMODELO_CELULAR());
    }
}
