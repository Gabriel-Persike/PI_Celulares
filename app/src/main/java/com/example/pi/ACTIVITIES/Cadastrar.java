package com.example.pi.ACTIVITIES;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.pi.Adapter.MarcaAdapter;
import com.example.pi.Model.Celular;
import com.example.pi.Model.Marca;
import com.example.pi.Model.PROCESSADOR;
import com.example.pi.R;
import com.example.pi.repository.CelularRepository;
import com.example.pi.repository.Repository;

public class Cadastrar extends AppCompatActivity {

    private EditText nome;
    private EditText preco;
    private Spinner spinnerMarca;
    private Celular celular;
    private Repository repository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        nome = (EditText) findViewById(R.id.nome);
        preco  = (EditText)findViewById(R.id.preco);
        spinnerMarca = (Spinner)findViewById(R.id.spinnerMarca);
        celular = new Celular();
        repository =  new Repository(getApplicationContext());
        loadMarca();
    }

    public void CadastrarCelular(View view) {
        celular.setMODELO_CELULAR(nome.getText().toString());
        celular.setPRECO(Integer.parseInt(preco.getText().toString()));
        repository.getCelularRepository().insert(celular);
        callMainActivity();
    }


    public void loadMarca(){
        final MarcaAdapter adapter = new MarcaAdapter(this,android.R.layout.simple_spinner_item,repository.getMarcaRepository().getAllMarcas());
        spinnerMarca.setAdapter(adapter);
        spinnerMarca.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

    public void addMarca(View view){
        showChangeLangDialogMarca();

    }

    public void addProcessador(View view){
        showChangeLangDialogProcessador();
    }

    public void showChangeLangDialogMarca() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_add_marca, null);
        dialogBuilder.setView(dialogView);

        final EditText edt = (EditText) dialogView.findViewById(R.id.dialog_Nome_Marca);

        dialogBuilder.setTitle("Nova marca");
        dialogBuilder.setPositiveButton("Adicionar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                Marca marca = new Marca(edt.getText().toString());
                repository.getMarcaRepository().insert(marca);
                loadMarca();
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    public void showChangeLangDialogProcessador() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_add_processador, null);
        dialogBuilder.setView(dialogView);

        final EditText editChipset = (EditText) dialogView.findViewById(R.id.dialog_Chipset);
        final EditText editNucleos = (EditText) dialogView.findViewById(R.id.dialog_Nucleos);
        final EditText editVelocidade = (EditText) dialogView.findViewById(R.id.dialog_Velocidade);

        dialogBuilder.setTitle("Novo processador");
        dialogBuilder.setPositiveButton("Adicionar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                PROCESSADOR processador = new PROCESSADOR(editChipset.getText().toString(), Integer.valueOf(editNucleos.getText().toString()), Integer.valueOf(editVelocidade.getText().toString()));
                repository.getProcessadorRepository().insert(processador);
                loadProcessador();
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }



    private void callMainActivity() {
        Intent mainActivity = new Intent(Cadastrar.this,MainActivity.class);
        startActivity(mainActivity);
        finish();
    }
}
