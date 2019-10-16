package com.example.pi.ACTIVITIES;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pi.R;

public class MainActivity extends AppCompatActivity {

    Button btnActivityCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnActivityCadastrar.findViewById(R.id.btnActvityCadastrar);
    }

    public void callActivityCadastrar(View view){
        Intent cadastrar = new Intent(MainActivity.this, Cadastrar.class);
        startActivity(cadastrar);
    }
}
