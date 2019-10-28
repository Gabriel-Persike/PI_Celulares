package com.example.pi.ACTIVITIES;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.pi.Adapter.CelularAdapter;
import com.example.pi.DAO.CelularDAO;
import com.example.pi.DAO.CelularDAO_Impl;
import com.example.pi.R;
import com.example.pi.repository.Repository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnActivityCadastrar;
    Repository repository;
    ArrayAdapter<CelularDAO.CelularJoin> adapter;
    ListView listCelulares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        repository = new Repository(getApplicationContext());
        btnActivityCadastrar = (Button) findViewById(R.id.btnActivityCadastrar);
        listCelulares = findViewById(R.id.listCelulares);
        loadCelular();
    }

    public void callActivityCadastrar(View view){
        Intent cadastrar = new Intent(MainActivity.this, Cadastrar.class);
        startActivity(cadastrar);
    }

    public void loadCelular(){
        List<CelularDAO.CelularJoin> celulares = repository.getCelularRepository().getmCelularJoin();
        adapter = new CelularAdapter(getApplicationContext(), R.layout.celular_item, celulares);
        listCelulares.setAdapter(adapter);
    }
}
