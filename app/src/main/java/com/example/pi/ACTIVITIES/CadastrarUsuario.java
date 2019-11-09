package com.example.pi.ACTIVITIES;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.example.pi.R;

public class CadastrarUsuario extends AppCompatActivity {
    private EditText editLogin, editSenha, editSenha2;
    private TextView textStatus;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);
        editLogin = findViewById(R.id.editLogin);
        editSenha = findViewById(R.id.editSenha);
        editSenha2 = findViewById(R.id.editSenha2);
        textStatus = findViewById(R.id.textStatus);
        mAuth = FirebaseAuth.getInstance();
    }

    public void signUpFB(View view){
        String login = editLogin.getText().toString();
        String senha = editSenha.getText().toString();
        String senha2 = editSenha2.getText().toString();

        if(!senha.equals(senha2)){
            textStatus.setVisibility(View.VISIBLE);
            textStatus.setText("Senhas não conferem.");
        }
        else{
            textStatus.setVisibility(View.VISIBLE);
            textStatus.setText("Criando usuário...");
            mAuth.createUserWithEmailAndPassword(login,senha).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    textStatus.setText("Usuário criado com sucesso! Redirecionando...");
                    dashRedirect();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    textStatus.setText("Não foi possível criar o usuário." + e);
                }
            });
        }
    }
    void dashRedirect(){
        Intent novaTela = new Intent(CadastrarUsuario.this,MainActivity.class);
        startActivity(novaTela);
    }

}
