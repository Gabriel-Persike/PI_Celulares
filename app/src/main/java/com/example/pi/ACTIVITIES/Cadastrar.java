package com.example.pi.ACTIVITIES;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Camera;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
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
import com.example.pi.repository.CelularRepository;
import com.example.pi.repository.Repository;

import org.w3c.dom.Text;

public class Cadastrar extends AppCompatActivity {

    private EditText nome;
    private EditText preco;
    private EditText armazenamento;
    private EditText memoriaRam;
    private Spinner spinnerMarca;
    private Spinner spinnerProcessador;
    private Spinner spinnerCamera;
    private Spinner spinnerSo;
    private Spinner spinnerTela;
    private Celular celular;
    private Repository repository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        nome = (EditText) findViewById(R.id.nome);
        preco  = (EditText)findViewById(R.id.preco);
        armazenamento = (EditText)findViewById(R.id.armazenamento);
        memoriaRam = (EditText)findViewById(R.id.memoriaRam);
        spinnerMarca = (Spinner)findViewById(R.id.spinnerMarca);
        spinnerProcessador = (Spinner)findViewById(R.id.spinnerProcessador);
        spinnerCamera = (Spinner)findViewById(R.id.spinnerCamera);
        spinnerSo = (Spinner)findViewById(R.id.spinnerSO);
        spinnerTela = (Spinner)findViewById(R.id.spinnerTela);
        celular = new Celular();
        repository =  new Repository(getApplicationContext());
        loadMarca();
        loadProcessador();
        loadCamera();
        loadSO();
        loadTela();
    }

    public void CadastrarCelular(View view) {
        celular.setMODELO_CELULAR(nome.getText().toString());
        String var = preco.getText().toString();
        if (var != null && var != ""){
            celular.setPRECO(Integer.parseInt(var));
        }
        var = armazenamento.getText().toString();
        if (var != null && var != ""){
            celular.setMEMORIA(Integer.valueOf(var));
        }
        var = memoriaRam.getText().toString();
        if (var != null && var != "") {
            celular.setMEMORIA_RAM(Integer.valueOf(var));
        }
        String resp = celular.isPreenchido();
        if (resp == "") {
            repository.getCelularRepository().insert(celular);
            callMainActivity();
        }
        else{
            Toast.makeText(this, ""+resp, Toast.LENGTH_LONG).show();
        }
    }

    public void addTela(View view){
        showChangeLangDialogTela();
    }

    public void addSO(View view){
        showChangeLangDialogSO();
    }

    public void addMarca(View view){
        showChangeLangDialogMarca();
    }

    public void addCamera(View view){
        showChangeLangDialogCamera();
    }

    public void addProcessador(View view){showChangeLangDialogProcessador();}

    public void attMarca(View view){showChangeLangDialogAttMarca();}

    public void attProcessador(View view){showChangeLangDialogAttProcessador();}

    public void attCamera(View view){showChangeLangDialogAttCamera();}

    public void attSO(View view){showChangeLangDialogAttSO();}

    public void attTela(View view){showChangeLangDialogAttTela();}

    public void delMarca(View view){showChangeLangDialogDelMarca();}
    public void delProcessador(View view){showChangeLangDialogDelProcessador();}
    public void delCamera(View view){showChangeLangDialogDelCamera();}
    public void delSO(View view){showChangeLangDialogDelSO();}
    public void delTela(View view){showChangeLangDialogDelTela();}


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
        spinnerSo.setAdapter(adapter);
        spinnerSo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
    public void showChangeLangDialogTela(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_add_tela, null);
        dialogBuilder.setView(dialogView);

        final EditText editTam = (EditText) dialogView.findViewById(R.id.dialog_tam_tela);
        final EditText editRes = (EditText) dialogView.findViewById(R.id.dialog_res_tela);

        dialogBuilder.setTitle("Nova Tela");
        dialogBuilder.setPositiveButton("Adicionar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                TELA tela = new TELA(Integer.valueOf(editTam.getText().toString()), editRes.getText().toString());
                repository.getTelaRepository().insert(tela);
                loadTela();
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    public void showChangeLangDialogAttTela(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_add_tela, null);
        dialogBuilder.setView(dialogView);

        final EditText editTam = (EditText) dialogView.findViewById(R.id.dialog_tam_tela);
        final EditText editRes = (EditText) dialogView.findViewById(R.id.dialog_res_tela);
        final TELA tela = repository.getTelaRepository().getTELAById(celular.getTELA_IDTELA());
        editTam.setText(String.valueOf(tela.getTAMANHO_TELA()));
        editRes.setText(tela.getRESOLUCAO_TELA());
        dialogBuilder.setTitle("Atualizar Tela");
        dialogBuilder.setPositiveButton("Atualizar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                tela.setRESOLUCAO_TELA(editRes.getText().toString());
                tela.setTAMANHO_TELA(Integer.valueOf(editTam.getText().toString()));
                repository.getTelaRepository().update(tela);
                loadTela();
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    public void showChangeLangDialogDelTela(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_del_tela, null);
        dialogBuilder.setView(dialogView);

        final TextView editTam = (TextView) dialogView.findViewById(R.id.dialog_tam_tela);
        final TextView editRes = (TextView) dialogView.findViewById(R.id.dialog_res_tela);
        final TELA tela = repository.getTelaRepository().getTELAById(celular.getTELA_IDTELA());
        editTam.setText("Tamanho: " + String.valueOf(tela.getTAMANHO_TELA()));
        editRes.setText("Resolução: " + tela.getRESOLUCAO_TELA());
        dialogBuilder.setTitle("Remover Tela");
        dialogBuilder.setPositiveButton("Remover", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                repository.getTelaRepository().delete(tela);
                loadTela();
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    public void showChangeLangDialogSO(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_add_so, null);
        dialogBuilder.setView(dialogView);

        final EditText editSo = (EditText) dialogView.findViewById(R.id.dialog_so);
        final EditText editVersao = (EditText) dialogView.findViewById(R.id.dialog_versao);

        dialogBuilder.setTitle("Novo SO");
        dialogBuilder.setPositiveButton("Adicionar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                SISTEMA_OPERACIONAL so = new SISTEMA_OPERACIONAL(editSo.getText().toString(),  editVersao.getText().toString());
                repository.getSoRepository().insert(so);
                loadSO();
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    public void showChangeLangDialogAttSO(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_add_so, null);
        dialogBuilder.setView(dialogView);

        final EditText editSo = (EditText) dialogView.findViewById(R.id.dialog_so);
        final EditText editVersao = (EditText) dialogView.findViewById(R.id.dialog_versao);
        final SISTEMA_OPERACIONAL so = repository.getSoRepository().getSistema_OperacionalById(celular.getSISTEMA_OPERACIONAL_IDSISTEMA_OPERACIONAL());
        editSo.setText(so.getNOME_SISTEMA_OPERACIONAL());
        editVersao.setText(so.getVERSOES());
        dialogBuilder.setTitle("Atualizar SO");
        dialogBuilder.setPositiveButton("Atualizar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                so.setNOME_SISTEMA_OPERACIONAL(editSo.getText().toString());
                so.setVERSOES(editVersao.getText().toString());
                repository.getSoRepository().update(so);
                loadSO();
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    public void showChangeLangDialogDelSO(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_del_so, null);
        dialogBuilder.setView(dialogView);

        final TextView editSo = (TextView) dialogView.findViewById(R.id.dialog_so);
        final TextView editVersao = (TextView) dialogView.findViewById(R.id.dialog_versao);
        final SISTEMA_OPERACIONAL so = repository.getSoRepository().getSistema_OperacionalById(celular.getSISTEMA_OPERACIONAL_IDSISTEMA_OPERACIONAL());
        editSo.setText("SO: " + so.getNOME_SISTEMA_OPERACIONAL());
        editVersao.setText("Versão: " + so.getVERSOES());
        dialogBuilder.setTitle("Deletar SO");
        dialogBuilder.setPositiveButton("Deletar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                repository.getSoRepository().delete(so);
                loadSO();
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
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

    public void showChangeLangDialogAttMarca() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_add_marca, null);
        dialogBuilder.setView(dialogView);
        final Marca marca = repository.getMarcaRepository().getMarcaById(celular.getMARCA_CELULAR_IDMARCA_CELULAR());
        final EditText edt = (EditText) dialogView.findViewById(R.id.dialog_Nome_Marca);
        edt.setText(marca.getNOME_MARCA_CELULAR());

        dialogBuilder.setTitle("Atualizar marca");
        dialogBuilder.setPositiveButton("Atualizar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                marca.setNOME_MARCA_CELULAR(edt.getText().toString());
                repository.getMarcaRepository().update(marca);
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

    public void showChangeLangDialogDelMarca() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_del_marca, null);
        dialogBuilder.setView(dialogView);
        final Marca marca = repository.getMarcaRepository().getMarcaById(celular.getMARCA_CELULAR_IDMARCA_CELULAR());
        final TextView edt = (TextView) dialogView.findViewById(R.id.dialog_Nome_Marca);
        edt.setText("Marca: " + marca.getNOME_MARCA_CELULAR());

        dialogBuilder.setTitle("Deletar marca");
        dialogBuilder.setPositiveButton("Deletar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                repository.getMarcaRepository().delete(marca);
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

    public void showChangeLangDialogAttProcessador() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_add_processador, null);
        dialogBuilder.setView(dialogView);
        final PROCESSADOR processador = repository.getProcessadorRepository().getProcessadorById(celular.getPROCESSADOR_IDPROCESSADOR());
        final EditText editChipset = (EditText) dialogView.findViewById(R.id.dialog_Chipset);
        final EditText editNucleos = (EditText) dialogView.findViewById(R.id.dialog_Nucleos);
        final EditText editVelocidade = (EditText) dialogView.findViewById(R.id.dialog_Velocidade);
        editChipset.setText(processador.getCHIPSET());
        editNucleos.setText(String.valueOf(processador.getNR_NUCLEOS()));
        editVelocidade.setText(String.valueOf(processador.getNR_VELOCIDADE()));
        dialogBuilder.setTitle("Atualizar processador");
        dialogBuilder.setPositiveButton("Atualizar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                processador.setCHIPSET(editChipset.getText().toString());
                processador.setNR_NUCLEOS(Integer.valueOf(editNucleos.getText().toString()));
                processador.setNR_VELOCIDADE(Integer.valueOf(editVelocidade.getText().toString()));
                repository.getProcessadorRepository().update(processador);
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

    public void showChangeLangDialogDelProcessador() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_del_processador, null);
        dialogBuilder.setView(dialogView);
        final PROCESSADOR processador = repository.getProcessadorRepository().getProcessadorById(celular.getPROCESSADOR_IDPROCESSADOR());
        final TextView editChipset = (TextView) dialogView.findViewById(R.id.dialog_Chipset);
        final TextView editNucleos = (TextView) dialogView.findViewById(R.id.dialog_Nucleos);
        final TextView editVelocidade = (TextView) dialogView.findViewById(R.id.dialog_Velocidade);
        editChipset.setText("Chipset: " + processador.getCHIPSET());
        editNucleos.setText("Nucleos: " + String.valueOf(processador.getNR_NUCLEOS()));
        editVelocidade.setText("Velocidade: " + String.valueOf(processador.getNR_VELOCIDADE()));
        dialogBuilder.setTitle("Deletar processador");
        dialogBuilder.setPositiveButton("Deletar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                repository.getProcessadorRepository().delete(processador);
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

    public void showChangeLangDialogCamera() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_add_camera, null);
        dialogBuilder.setView(dialogView);

        final EditText editFrontal = (EditText) dialogView.findViewById(R.id.dialog_camera_frontal);
        final EditText editTraseira = (EditText) dialogView.findViewById(R.id.dialog_camera_traseira);

        dialogBuilder.setTitle("Nova camera");
        dialogBuilder.setPositiveButton("Adicionar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                CAMERA camera = new CAMERA(editTraseira.getText().toString(), editFrontal.getText().toString());
                repository.getCameraRepository().insert(camera);
                loadCamera();
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    public void showChangeLangDialogAttCamera() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_add_camera, null);
        dialogBuilder.setView(dialogView);

        final EditText editFrontal = (EditText) dialogView.findViewById(R.id.dialog_camera_frontal);
        final EditText editTraseira = (EditText) dialogView.findViewById(R.id.dialog_camera_traseira);
        final CAMERA camera = repository.getCameraRepository().getCAMERAById(celular.getCAMERA_IDCAMERA());
        editFrontal.setText(camera.getCAMERA_FRONTAL());
        editTraseira.setText(camera.getCAMERA_TRASEIRA());
        dialogBuilder.setTitle("Atualizar camera");
        dialogBuilder.setPositiveButton("Atualizar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                camera.setCAMERA_FRONTAL(editFrontal.getText().toString());
                camera.setCAMERA_TRASEIRA(editTraseira.getText().toString());
                repository.getCameraRepository().update(camera);
                loadCamera();
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }


    public void showChangeLangDialogDelCamera() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_del_camera, null);
        dialogBuilder.setView(dialogView);

        final TextView editFrontal = (TextView) dialogView.findViewById(R.id.dialog_camera_frontal);
        final TextView editTraseira = (TextView) dialogView.findViewById(R.id.dialog_camera_traseira);
        final CAMERA camera = repository.getCameraRepository().getCAMERAById(celular.getCAMERA_IDCAMERA());
        editFrontal.setText("Camera frontral: " + camera.getCAMERA_FRONTAL());
        editTraseira.setText("Camera trasera" + camera.getCAMERA_TRASEIRA());
        dialogBuilder.setTitle("Deletar camera");
        dialogBuilder.setPositiveButton("Deletar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                repository.getCameraRepository().delete(camera);
                loadCamera();
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
