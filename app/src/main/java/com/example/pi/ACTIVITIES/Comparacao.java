package com.example.pi.ACTIVITIES;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.pi.DAO.CelularDAO;
import com.example.pi.R;
import com.example.pi.repository.Repository;

public class Comparacao extends AppCompatActivity {

    private CelularDAO.CelularJoin celular1;
    private CelularDAO.CelularJoin celular2;
    private Repository repository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparacao);
        repository = new Repository(getApplicationContext());
        celular1 = repository.getCelularRepository().getCelularJoinById(getIntent().getIntExtra("ID1", 0));
        celular2 = repository.getCelularRepository().getCelularJoinById(getIntent().getIntExtra("ID2", 0));

    }
}
