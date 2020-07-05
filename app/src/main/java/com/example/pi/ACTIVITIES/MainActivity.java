package com.example.pi.ACTIVITIES;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pi.Adapter.CelularAdapter;
import com.example.pi.Adapter.MarcaAdapter;
import com.example.pi.DAO.CelularDAO;
import com.example.pi.Model.Celular;
import com.example.pi.Model.Marca;
import com.example.pi.R;
import com.example.pi.repository.Repository;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.util.List;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    Button btnActivityCadastrar;
    Repository repository;
    ArrayAdapter<CelularDAO.CelularJoin> adapter;
    ListView listCelulares;
    private Spinner spinnerOptMarca;
    private FirebaseAuth mAuth;
    private TextView textLogin;
    private Celular celular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            repository = new Repository(getApplicationContext());
            btnActivityCadastrar = (Button) findViewById(R.id.btnActivityCadastrar);
            listCelulares = findViewById(R.id.listCelulares);
            listCelulares.setOnItemClickListener(this);
            textLogin = (TextView) findViewById(R.id.textLogin);
        spinnerOptMarca = (Spinner) findViewById(R.id.spinnerOptMarca);
        mAuth = FirebaseAuth.getInstance();
        celular = new Celular();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            textLogin.setText("Bem vindo: " + mAuth.getCurrentUser().getEmail());
        }
        loadCelular();
        loadMarca();
    }

    public void callActivityCadastrar(View view){
        Intent cadastrar = new Intent(MainActivity.this, Cadastrar.class);
        startActivity(cadastrar);
    }

    public void logout(View view){
        mAuth.signOut();
        callActivityLogin(view);

    }

    public void Listar(View view){
        loadCelular();
    }

    public void ListarPorMarca(View view){
        List<CelularDAO.CelularJoin> celulares = repository.getCelularRepository().getCelularJoinByMarca(celular.getMARCA_CELULAR_IDMARCA_CELULAR());
        adapter = new CelularAdapter(getApplicationContext(), R.layout.celular_item, celulares);
        listCelulares.setAdapter(adapter);
    }

    public void loadMarca(){
        final MarcaAdapter adapter = new MarcaAdapter(this,android.R.layout.simple_spinner_item,repository.getMarcaRepository().getAllMarcas());
        spinnerOptMarca.setAdapter(adapter);
        spinnerOptMarca.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Marca marca = (Marca) adapterView.getItemAtPosition(i);
                celular.setMARCA_CELULAR_IDMARCA_CELULAR(marca.getIDMARCA_CELULAR());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void callActivityLogin(View view){
        Intent login = new Intent(MainActivity.this, Login.class);
        startActivity(login);
    }


    public void loadCelular(){
        List<CelularDAO.CelularJoin> celulares = repository.getCelularRepository().getmCelularJoin();
        adapter = new CelularAdapter(getApplicationContext(), R.layout.celular_item, celulares);
        listCelulares.setAdapter(adapter);
    }

    public void callActivityAtualizar(int id){
            Intent atualizar = new Intent(MainActivity.this,atualizarCelular.class);
            atualizar.putExtra("ID",id);
            startActivity(atualizar);
    }

    public void callActivityComparar(int id){
        Intent comparar = new Intent(MainActivity.this,Comparar.class);
        comparar.putExtra("ID",id);
        startActivity(comparar);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        final CelularDAO.CelularJoin celularJoin = (CelularDAO.CelularJoin) adapterView.getItemAtPosition(i);
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("O que fazer com " + celularJoin.celular.getMODELO_CELULAR()).setItems(R.array.opcoes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int which) {
                if(which == 0){
                    callActivityComparar(celularJoin.celular.getIDMODELO_CELULAR());
                }
                if(which == 1) {
                    repository.getCelularRepository().delete(celularJoin.celular);
                    loadCelular();
                }
                else if(which == 2){
                   callActivityAtualizar(celularJoin.celular.getIDMODELO_CELULAR());
                }
                else if(which == 4){
                    getToken();
                }
            }
        }).create().show();
    }

    public void getToken(){
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w("getInstanceId failed", task.getException());
                            return;
                        }
                        else{
                            String token = task.getResult().getToken();
                            Log.d("token",token);
                        }
                    }
                });
    }

}
