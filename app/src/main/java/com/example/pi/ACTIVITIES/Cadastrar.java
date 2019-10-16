package com.example.pi.ACTIVITIES;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.pi.Model.Celular;
import com.example.pi.R;

public class Cadastrar extends AppCompatActivity {

    EditText nome;
    EditText preco;
    EditText marca;
    EditText ano;
    Celular celular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        nome.findViewById(R.id.nome);
        preco.findViewById(R.id.preco);
        marca.findViewById(R.id.marca);
        ano.findViewById(R.id.ano);
        celular = new Celular();
    }

    public void CadastrarCelular(View view) {
        celular.setNome(nome.getText().toString());
        celular.setPreco((int)preco.getText().toString());
    }

}
