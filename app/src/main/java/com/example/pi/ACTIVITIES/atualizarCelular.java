package com.example.pi.ACTIVITIES;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pi.Adapter.CameraAdapter;
import com.example.pi.Adapter.MarcaAdapter;
import com.example.pi.Adapter.ProcessadorAdapter;
import com.example.pi.Adapter.SoAdapter;
import com.example.pi.Adapter.TelaAdapter;
import com.example.pi.Model.CAMERA;
import com.example.pi.Model.Celular;
import com.example.pi.Model.Marca;
import com.example.pi.Model.PROCESSADOR;
import com.example.pi.Model.SISTEMA_OPERACIONAL;
import com.example.pi.Model.TELA;
import com.example.pi.R;
import com.example.pi.repository.Repository;

public class atualizarCelular extends AppCompatActivity {

    EditText editnome;
    EditText editpreco;
    EditText editmemoriaRam;
    EditText armazenamento;
    Spinner spinnerMarca;
    Spinner spinnerProcessador;
    Spinner spinnerCamera;
    Spinner spinnerSO;
    Spinner spinnerTela;
    Celular celular;
    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_celular);
        repository = new Repository(getApplicationContext());

        long celular_id = getIntent().getIntExtra("ID", 0);
        Log.i("Celular: ", String.valueOf(celular_id));

        Toast.makeText(this, "ID = " + celular_id, Toast.LENGTH_SHORT).show();

        editnome = (EditText) findViewById(R.id.nomeAtualiza);
        editpreco = (EditText) findViewById(R.id.precoAtualiza);
        editmemoriaRam = (EditText) findViewById(R.id.memoriaRamAtualiza);
        armazenamento = (EditText) findViewById(R.id.armazenamentoAtualiza);
        spinnerMarca = (Spinner) findViewById(R.id.spinnerMarcaAtualiza);
        spinnerProcessador = (Spinner) findViewById(R.id.spinnerProcessadorAtualiza);
        spinnerMarca = (Spinner) findViewById(R.id.spinnerProcessadorAtualiza);
        spinnerCamera = (Spinner) findViewById(R.id.spinnerCameraAtualiza);
        spinnerSO = (Spinner) findViewById(R.id.spinnerSOAtualiza);
        spinnerTela = (Spinner) findViewById(R.id.spinnerTelaAtualiza);

        loadMarca();
        loadCamera();
        loadProcessador();
        loadSO();
        loadTela();
        loadCelular(celular_id);
    }

    public void loadCelular(long id){
        celular = repository.getCelularRepository().getCelularById((int)id);
        editnome.setText(celular.getMODELO_CELULAR());
        editpreco.setText(String.valueOf(celular.getPRECO()));
        editmemoriaRam.setText(String.valueOf(celular.getMEMORIA_RAM()));
        armazenamento.setText(String.valueOf(celular.getMEMORIA()));
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


    public void loadCamera(){
        final CameraAdapter adapter = new CameraAdapter(this,android.R.layout.simple_spinner_item,repository.getCameraRepository().getCameras());
        spinnerCamera.setAdapter(adapter);
        spinnerCamera.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                CAMERA camera = (CAMERA) adapterView.getItemAtPosition(i);
                celular.setCAMERA_IDCAMERA(camera.getIDCAMERA());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void loadProcessador(){
        final ProcessadorAdapter adapter = new ProcessadorAdapter(this,android.R.layout.simple_spinner_item,repository.getProcessadorRepository().getProcessadores());
        spinnerProcessador.setAdapter(adapter);
        spinnerProcessador.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                PROCESSADOR processador = (PROCESSADOR) adapterView.getItemAtPosition(i);
                celular.setPROCESSADOR_IDPROCESSADOR(processador.getIDPROCESSADOR());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void loadSO(){
        final SoAdapter adapter = new SoAdapter(this,android.R.layout.simple_spinner_item,repository.getSoRepository().getSistema_Operacional());
        spinnerSO.setAdapter(adapter);
        spinnerSO.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SISTEMA_OPERACIONAL so = (SISTEMA_OPERACIONAL) adapterView.getItemAtPosition(i);
                celular.setSISTEMA_OPERACIONAL_IDSISTEMA_OPERACIONAL(so.getIDSISTEMA_OPERACIONAL());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void loadTela(){
        final TelaAdapter adapter = new TelaAdapter(this,android.R.layout.simple_spinner_item,repository.getTelaRepository().getTELA());
        spinnerTela.setAdapter(adapter);
        spinnerTela.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                TELA tela = (TELA) adapterView.getItemAtPosition(i);
                celular.setTELA_IDTELA(tela.getIDTELA());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
