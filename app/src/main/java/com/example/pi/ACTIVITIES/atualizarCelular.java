package com.example.pi.ACTIVITIES;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pi.Adapter.CameraAdapter;
import com.example.pi.Adapter.MarcaAdapter;
import com.example.pi.Adapter.ProcessadorAdapter;
import com.example.pi.Adapter.SoAdapter;
import com.example.pi.Adapter.TelaAdapter;
import com.example.pi.DAO.CelularDAO;
import com.example.pi.Model.CAMERA;
import com.example.pi.Model.Celular;
import com.example.pi.Model.Marca;
import com.example.pi.Model.PROCESSADOR;
import com.example.pi.Model.SISTEMA_OPERACIONAL;
import com.example.pi.Model.TELA;
import com.example.pi.R;
import com.example.pi.repository.Repository;

import java.util.List;

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
    private RatingBar ratingNotaDesempenho;
    private RatingBar ratingNotaCusto;
    private RatingBar ratingNotaTela;
    private RatingBar ratingNotaCamera;
    private RatingBar ratingNotaHardware;
    CelularDAO.CelularJoin celular;
    Repository repository;
    private MarcaAdapter marcaAdapter;
    private ProcessadorAdapter processadorAdapter;
    private TelaAdapter telaAdapter;
    private CameraAdapter cameraAdapter;
    private SoAdapter soAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_celular);
        repository = new Repository(getApplicationContext());

        int celular_id = getIntent().getIntExtra("ID", 0);
        Log.i("Celular: ", String.valueOf(celular_id));

        Toast.makeText(this, "ID = " + celular_id, Toast.LENGTH_SHORT).show();

        editnome = (EditText) findViewById(R.id.nomeAtualiza);
        editpreco = (EditText) findViewById(R.id.precoAtualiza);
        editmemoriaRam = (EditText) findViewById(R.id.memoriaRamAtualiza);
        armazenamento = (EditText) findViewById(R.id.armazenamentoAtualiza);
        spinnerMarca = (Spinner) findViewById(R.id.spinnerMarcaAtualiza);
        spinnerProcessador = (Spinner) findViewById(R.id.spinnerProcessadorAtualiza);
        spinnerCamera = (Spinner) findViewById(R.id.spinnerCameraAtualiza);
        spinnerSO = (Spinner) findViewById(R.id.spinnerSOAtualiza);
        spinnerTela = (Spinner) findViewById(R.id.spinnerTelaAtualiza);
        ratingNotaDesempenho = (RatingBar) findViewById(R.id.ratingNotaDesempenho);
        ratingNotaCusto = (RatingBar) findViewById(R.id.ratingNotaCusto);
        ratingNotaTela = (RatingBar) findViewById(R.id.ratingNotaTela);
        ratingNotaCamera = (RatingBar) findViewById(R.id.ratingNotaCamera);
        ratingNotaHardware = (RatingBar) findViewById(R.id.ratingNotaHardware);

        marcaAdapter= new MarcaAdapter(this,android.R.layout.simple_spinner_item,repository.getMarcaRepository().getAllMarcas());
        processadorAdapter = new ProcessadorAdapter(this, android.R.layout.simple_spinner_item, repository.getProcessadorRepository().getProcessadores());
        telaAdapter = new TelaAdapter(this, android.R.layout.simple_spinner_item, repository.getTelaRepository().getTELA());
        cameraAdapter = new CameraAdapter(this, android.R.layout.simple_spinner_item, repository.getCameraRepository().getCameras());
        soAdapter = new SoAdapter(this, android.R.layout.simple_spinner_item, repository.getSoRepository().getSistema_Operacional());


        loadMarca();
        loadCamera();
        loadProcessador();
        loadSO();
        loadTela();
        loadCelular(celular_id);
    }

    public void loadCelular(int id){
        celular = repository.getCelularRepository().getCelularJoinById(id);
        editnome.setText(celular.celular.getMODELO_CELULAR());
        editpreco.setText(String.valueOf(celular.celular.getPRECO()));
        editmemoriaRam.setText(String.valueOf(celular.celular.getMEMORIA_RAM()));
        armazenamento.setText(String.valueOf(celular.celular.getMEMORIA()));
        spinnerMarca.setAdapter(marcaAdapter);
        ratingNotaDesempenho.setRating(celular.notas.getDesempenho());
        ratingNotaCusto.setRating(celular.notas.getCusto_Beneficio());
        ratingNotaTela.setRating(celular.notas.getTela());
        ratingNotaCamera.setRating(celular.notas.getCamera());
        ratingNotaHardware.setRating(celular.notas.getHardware());

        List<Marca> marcas = repository.getMarcaRepository().getAllMarcas();
        int counter = 0;
        for(Marca m : marcas){
            if(celular.celular.getMARCA_CELULAR_IDMARCA_CELULAR() == m.getIDMARCA_CELULAR()){
                spinnerMarca.setSelection(counter);
            }
            counter++;
        }
        spinnerCamera.setAdapter(cameraAdapter);
        List<CAMERA> cameras = repository.getCameraRepository().getCameras();
        counter = 0;
        for(CAMERA c : cameras) {
            if (celular.celular.getCAMERA_IDCAMERA() == c.getIDCAMERA()) {
                spinnerCamera.setSelection(counter);
            }
            counter++;
        }

        spinnerProcessador.setAdapter(processadorAdapter);
        List<PROCESSADOR> processadores = repository.getProcessadorRepository().getProcessadores();
        counter = 0;
        for(PROCESSADOR p : processadores) {
            if (celular.celular.getPROCESSADOR_IDPROCESSADOR() == p.getIDPROCESSADOR()) {
                spinnerProcessador.setSelection(counter);
            }
            counter++;
        }

        spinnerSO.setAdapter(soAdapter);
        List<SISTEMA_OPERACIONAL> sos = repository.getSoRepository().getSistema_Operacional();
        counter = 0;
        for(SISTEMA_OPERACIONAL s : sos) {
            if (celular.celular.getSISTEMA_OPERACIONAL_IDSISTEMA_OPERACIONAL() == s.getIDSISTEMA_OPERACIONAL()) {
                spinnerSO.setSelection(counter);
            }
            counter++;
        }

        spinnerTela.setAdapter(telaAdapter);
        List<TELA> telas = repository.getTelaRepository().getTELA();
        counter = 0;
        for(TELA t : telas) {
            if (celular.celular.getTELA_IDTELA() == t.getIDTELA()) {
                spinnerTela.setSelection(counter);
            }
            counter++;
        }
    }



    public void loadMarca(){
        final MarcaAdapter adapter = new MarcaAdapter(this,android.R.layout.simple_spinner_item,repository.getMarcaRepository().getAllMarcas());
        spinnerMarca.setAdapter(adapter);
        spinnerMarca.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Marca marca = (Marca) adapterView.getItemAtPosition(i);
                celular.celular.setMARCA_CELULAR_IDMARCA_CELULAR(marca.getIDMARCA_CELULAR());
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
                celular.celular.setCAMERA_IDCAMERA(camera.getIDCAMERA());
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
                celular.celular.setPROCESSADOR_IDPROCESSADOR(processador.getIDPROCESSADOR());
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
                celular.celular.setSISTEMA_OPERACIONAL_IDSISTEMA_OPERACIONAL(so.getIDSISTEMA_OPERACIONAL());
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
                celular.celular.setTELA_IDTELA(tela.getIDTELA());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void updateCelular(View view){
        celular.celular.setMODELO_CELULAR(editnome.getText().toString());
        celular.celular.setMEMORIA(Integer.valueOf(armazenamento.getText().toString()));
        celular.celular.setMEMORIA_RAM(Integer.valueOf(editmemoriaRam.getText().toString()));
        celular.celular.setPRECO(Float.valueOf(editpreco.getText().toString()));
        celular.notas.setCamera(ratingNotaCamera.getRating());
        celular.notas.setCusto_Beneficio(ratingNotaCusto.getRating());
        celular.notas.setDesempenho(ratingNotaDesempenho.getRating());
        celular.notas.setHardware(ratingNotaHardware.getRating());
        celular.notas.setTela(ratingNotaTela.getRating());
        String resp = celular.celular.isPreenchido();
        if (resp == ""){
            repository.getCelularRepository().update(celular.celular);
            repository.getNotasRepository().update(celular.notas);
            callMainActivity();
        }
        else{
            Toast.makeText(this, "Erro " + celular.celular.isPreenchido(), Toast.LENGTH_SHORT).show();
        }
    }

    private void callMainActivity() {
        Intent mainActivity = new Intent(atualizarCelular.this,MainActivity.class);
        startActivity(mainActivity);
        finish();
    }
}
