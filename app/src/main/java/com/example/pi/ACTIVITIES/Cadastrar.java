package com.example.pi.ACTIVITIES;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.pi.Model.Celular;
import com.example.pi.R;
import com.example.pi.repository.CelularRepository;

public class Cadastrar extends AppCompatActivity {

    EditText nome;
    EditText preco;
    EditText marca;
    EditText ano;
    CelularRepository Rep = new CelularRepository(getApplicationContext());
    Celular celular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        nome = (EditText) findViewById(R.id.nome);
        preco  = (EditText)findViewById(R.id.preco);
        marca = (EditText)findViewById(R.id.marca);
        ano  = (EditText)findViewById(R.id.ano);
        celular = new Celular();
    }

    public void CadastrarCelular(View view) {
        celular.setNome(nome.getText().toString());
        celular.setPreco(Double.parseDouble(preco.getText().toString()));
        celular.setAnoProducao(Integer.parseInt(ano.getText().toString()));
        Rep.insert(celular);
        callMainActivity();
    }


    private void callMainActivity() {
        Intent mainActivity = new Intent(Cadastrar.this,MainActivity.class);
        startActivity(mainActivity);
        finish();
    }
}
