package com.example.pi.ACTIVITIES;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pi.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText editLogin;
    private EditText editSenha;
    private TextView textStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        editLogin = findViewById(R.id.editLogin);
        editSenha = findViewById(R.id.editSenha);
        textStatus = findViewById(R.id.textStatus);
    }

    @Override
    public void onStart(){
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }


    void updateUI(FirebaseUser currentUser){
        if(currentUser != null){
            dashRedirect();
        }
        else{
            Toast.makeText(this, "Usuário não logado.", Toast.LENGTH_SHORT).show();
        }
    }

    public void signIn(View view) {
        String login = editLogin.getText().toString();
        String senha = editSenha.getText().toString();
        textStatus.setVisibility(View.VISIBLE);
        textStatus.setText("Buscando info sobre usuário");
        if (login.equals("")){
            textStatus.setText("Login não informado.");
        }
        else if (senha.equals("")){
            textStatus.setText("Senha não informado.");
        }
        else{
            mAuth.signInWithEmailAndPassword(login,senha).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    textStatus.setVisibility(View.GONE);
                    updateUI(mAuth.getCurrentUser());
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    textStatus.setText("Usuário/Senha não conferem.");
                }
            });
        }

    }

    public void signUp(View view) {
        signUpRedirect();
    }

    void dashRedirect(){
        Intent novaTela = new Intent(Login.this,MainActivity.class);
        startActivity(novaTela);
    }
    void signUpRedirect(){
        Intent novaTela = new Intent(Login.this,CadastrarUsuario.class);
        startActivity(novaTela);
    }
}
