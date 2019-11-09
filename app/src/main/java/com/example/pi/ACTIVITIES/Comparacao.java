package com.example.pi.ACTIVITIES;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pi.DAO.CelularDAO;
import com.example.pi.R;
import com.example.pi.repository.Repository;

import org.w3c.dom.Text;

public class Comparacao extends AppCompatActivity {

    private CelularDAO.CelularJoin celular1;
    private CelularDAO.CelularJoin celular2;
    private Repository repository;
    private TextView comparacaoTextModeloNome1, comparacaoTextModeloNome2, comparacaoTextModeloPreco1, comparacaoTextModeloPreco2,
            comparacaoTextModeloMemoria1, comparacaoTextModeloMemoria2, comparacaoTextModeloArmazenamento1,
            comparacaoTextModeloArmazenamento2, comparacaoTextModeloMarca1, comparacaoTextModeloMarca2, comparacaoTextModeloChipset1,
            comparacaoTextModeloChipset2, comparacaoTextModeloNucleos1, comparacaoTextModeloNucleos2, comparacaoTextModeloVelocidade1,
            comparacaoTextModeloVelocidade2, comparacaoTextModeloSO1, comparacaoTextModeloSO2, comparacaoTextModeloVercao1,
            comparacaoTextModeloVercao2, comparacaoTextModeloTamanho1, comparacaoTextModeloTamanho2, comparacaoTextModeloResolucao1,
            comparacaoTextModeloResolucao2, comparacaoTextModeloFrontal1, comparacaoTextModeloFrontal2,
            comparacaoTextModeloTraseira1, comparacaoTextModeloTraseira2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparacao);
        repository = new Repository(getApplicationContext());
        celular1 = repository.getCelularRepository().getCelularJoinById(getIntent().getIntExtra("ID1", 0));
        celular2 = repository.getCelularRepository().getCelularJoinById(getIntent().getIntExtra("ID2", 0));
        comparacaoTextModeloNome1 = (TextView) findViewById(R.id.comparacaoTextModeloNome1);
        comparacaoTextModeloNome2 = (TextView) findViewById(R.id.comparacaoTextModeloNome2);
        comparacaoTextModeloPreco1 = (TextView) findViewById(R.id.comparacaoTextModeloPreco1);
        comparacaoTextModeloPreco2 = (TextView) findViewById(R.id.comparacaoTextModeloPreco2);
        comparacaoTextModeloMemoria1 = (TextView) findViewById(R.id.comparacaoTextModeloMemoria1);
        comparacaoTextModeloMemoria2 = (TextView) findViewById(R.id.comparacaoTextModeloMemoria2);
        comparacaoTextModeloArmazenamento1 = (TextView) findViewById(R.id.comparacaoTextModeloArmazenamento1);
        comparacaoTextModeloArmazenamento2 = (TextView) findViewById(R.id.comparacaoTextModeloArmazenamento2);
        comparacaoTextModeloMarca1 = (TextView) findViewById(R.id.comparacaoTextModeloMarca1);
        comparacaoTextModeloMarca2 = (TextView) findViewById(R.id.comparacaoTextModeloMarca2);
        comparacaoTextModeloChipset1 = (TextView) findViewById(R.id.comparacaoTextModeloChipset1);
        comparacaoTextModeloChipset2 = (TextView) findViewById(R.id.comparacaoTextModeloChipset2);
        comparacaoTextModeloNucleos1 = (TextView) findViewById(R.id.comparacaoTextModeloNucleos1);
        comparacaoTextModeloNucleos2 = (TextView) findViewById(R.id.comparacaoTextModeloNucleos2);
        comparacaoTextModeloVelocidade1 = (TextView) findViewById(R.id.comparacaoTextModeloVelocidade1);
        comparacaoTextModeloVelocidade2 = (TextView) findViewById(R.id.comparacaoTextModeloVelocidade2);
        comparacaoTextModeloSO1 = (TextView) findViewById(R.id.comparacaoTextModeloSO1);
        comparacaoTextModeloSO2 = (TextView) findViewById(R.id.comparacaoTextModeloSO2);
        comparacaoTextModeloVercao1 = (TextView) findViewById(R.id.comparacaoTextModeloVercao1);
        comparacaoTextModeloVercao2 = (TextView) findViewById(R.id.comparacaoTextModeloVercao2);
        comparacaoTextModeloTamanho1 = (TextView) findViewById(R.id.comparacaoTextModeloTamanho1);
        comparacaoTextModeloTamanho2 = (TextView) findViewById(R.id.comparacaoTextModeloTamanho2);
        comparacaoTextModeloResolucao1 = (TextView) findViewById(R.id.comparacaoTextModeloResolucao1);
        comparacaoTextModeloResolucao2 = (TextView) findViewById(R.id.comparacaoTextModeloResolucao2);
        comparacaoTextModeloFrontal1 = (TextView) findViewById(R.id.comparacaoTextModeloFrontal1);
        comparacaoTextModeloFrontal2 = (TextView) findViewById(R.id.comparacaoTextModeloFrontal2);
        comparacaoTextModeloTraseira1 = (TextView) findViewById(R.id.comparacaoTextModeloTraseira1);
        comparacaoTextModeloTraseira2 = (TextView) findViewById(R.id.comparacaoTextModeloTraseira2);
        loadCelulares();

    }


    public void loadCelulares(){
        comparacaoTextModeloNome1.setText(celular1.celular.getMODELO_CELULAR());
        comparacaoTextModeloNome2.setText(celular2.celular.getMODELO_CELULAR());
        comparacaoTextModeloPreco1.setText(String.valueOf(celular1.celular.getPRECO()));
        comparacaoTextModeloPreco2.setText(String.valueOf(celular2.celular.getPRECO()));
        comparacaoTextModeloMemoria1.setText(String.valueOf(celular1.celular.getMEMORIA_RAM()));
        comparacaoTextModeloMemoria2.setText(String.valueOf(celular2.celular.getMEMORIA_RAM()));
        comparacaoTextModeloArmazenamento1.setText(String.valueOf(celular1.celular.getMEMORIA()));
        comparacaoTextModeloArmazenamento2.setText(String.valueOf(celular2.celular.getMEMORIA()));
        comparacaoTextModeloMarca1.setText(celular1.marca.getNOME_MARCA_CELULAR());
        comparacaoTextModeloMarca2.setText(celular2.marca.getNOME_MARCA_CELULAR());
        comparacaoTextModeloChipset1.setText(celular1.processador.getCHIPSET());
        comparacaoTextModeloChipset2.setText(celular2.processador.getCHIPSET());
        comparacaoTextModeloNucleos1.setText(String.valueOf(celular1.processador.getNR_NUCLEOS()));
        comparacaoTextModeloNucleos2.setText(String.valueOf(celular2.processador.getNR_NUCLEOS()));
        comparacaoTextModeloVelocidade1.setText(String.valueOf(celular1.processador.getNR_VELOCIDADE()));
        comparacaoTextModeloVelocidade2.setText(String.valueOf(celular2.processador.getNR_VELOCIDADE()));
        comparacaoTextModeloSO1.setText(celular1.so.getNOME_SISTEMA_OPERACIONAL());
        comparacaoTextModeloSO2.setText(celular2.so.getNOME_SISTEMA_OPERACIONAL());
        comparacaoTextModeloVercao1.setText(celular1.so.getVERSOES());
        comparacaoTextModeloVercao2.setText(celular2.so.getVERSOES());
        comparacaoTextModeloTamanho1.setText(String.valueOf(celular1.tela.getTAMANHO_TELA()));
        comparacaoTextModeloTamanho2.setText(String.valueOf(celular2.tela.getTAMANHO_TELA()));
        comparacaoTextModeloResolucao1.setText(celular1.tela.getRESOLUCAO_TELA());
        comparacaoTextModeloResolucao2.setText(celular2.tela.getRESOLUCAO_TELA());
        comparacaoTextModeloFrontal1.setText(celular1.camera.getCAMERA_FRONTAL());
        comparacaoTextModeloFrontal2.setText(celular2.camera.getCAMERA_FRONTAL());
        comparacaoTextModeloTraseira1.setText(celular1.camera.getCAMERA_TRASEIRA());
        comparacaoTextModeloTraseira2.setText(celular2.camera.getCAMERA_TRASEIRA());
        //Set rating DESEMPENGO
        if (celular1.notas.getDesempenho() > celular2.notas.getDesempenho()){
            comparacaoTextModeloSO1.setBackgroundColor(Color.GREEN);
            comparacaoTextModeloVercao1.setBackgroundColor(Color.GREEN);
            comparacaoTextModeloSO2.setBackgroundColor(Color.RED);
            comparacaoTextModeloVercao2.setBackgroundColor(Color.RED);

        }
        else if(celular1.notas.getCamera() < celular2.notas.getCamera()){
            comparacaoTextModeloSO1.setBackgroundColor(Color.RED);
            comparacaoTextModeloVercao1.setBackgroundColor(Color.RED);
            comparacaoTextModeloSO2.setBackgroundColor(Color.GREEN);
            comparacaoTextModeloVercao2.setBackgroundColor(Color.GREEN);
        }
        else{
            comparacaoTextModeloSO1.setBackgroundColor(Color.YELLOW);
            comparacaoTextModeloVercao1.setBackgroundColor(Color.YELLOW);
            comparacaoTextModeloSO2.setBackgroundColor(Color.YELLOW);
            comparacaoTextModeloVercao2.setBackgroundColor(Color.YELLOW);
        }

        //Set rating CUSTOBENEFICIO
        if (celular1.notas.getCusto_Beneficio() > celular2.notas.getCusto_Beneficio()){
            comparacaoTextModeloNome1.setBackgroundColor(Color.GREEN);
            comparacaoTextModeloPreco1.setBackgroundColor(Color.GREEN);
            comparacaoTextModeloMemoria1.setBackgroundColor(Color.GREEN);
            comparacaoTextModeloArmazenamento1.setBackgroundColor(Color.GREEN);
            comparacaoTextModeloNome2.setBackgroundColor(Color.RED);
            comparacaoTextModeloPreco2.setBackgroundColor(Color.RED);
            comparacaoTextModeloMemoria2.setBackgroundColor(Color.RED);
            comparacaoTextModeloArmazenamento2.setBackgroundColor(Color.RED);
        }
        else if(celular1.notas.getCusto_Beneficio() < celular2.notas.getCusto_Beneficio()){
            comparacaoTextModeloNome1.setBackgroundColor(Color.RED);
            comparacaoTextModeloPreco1.setBackgroundColor(Color.RED);
            comparacaoTextModeloMemoria1.setBackgroundColor(Color.RED);
            comparacaoTextModeloArmazenamento1.setBackgroundColor(Color.RED);
            comparacaoTextModeloNome2.setBackgroundColor(Color.GREEN);
            comparacaoTextModeloPreco2.setBackgroundColor(Color.GREEN);
            comparacaoTextModeloMemoria2.setBackgroundColor(Color.GREEN);
            comparacaoTextModeloArmazenamento2.setBackgroundColor(Color.GREEN);
        }
        else{
            comparacaoTextModeloNome1.setBackgroundColor(Color.YELLOW);
            comparacaoTextModeloPreco1.setBackgroundColor(Color.YELLOW);
            comparacaoTextModeloMemoria1.setBackgroundColor(Color.YELLOW);
            comparacaoTextModeloArmazenamento1.setBackgroundColor(Color.YELLOW);
            comparacaoTextModeloNome2.setBackgroundColor(Color.YELLOW);
            comparacaoTextModeloPreco2.setBackgroundColor(Color.YELLOW);
            comparacaoTextModeloMemoria2.setBackgroundColor(Color.YELLOW);
            comparacaoTextModeloArmazenamento2.setBackgroundColor(Color.YELLOW);
        }
        //Set rating TELA
        if (celular1.notas.getTela() > celular2.notas.getTela()){
            comparacaoTextModeloResolucao1.setBackgroundColor(Color.GREEN);
            comparacaoTextModeloTamanho1.setBackgroundColor(Color.GREEN);
            comparacaoTextModeloResolucao2.setBackgroundColor(Color.RED);
            comparacaoTextModeloTamanho2.setBackgroundColor(Color.RED);
        }
        else if(celular1.notas.getTela() < celular2.notas.getTela()){
            comparacaoTextModeloResolucao1.setBackgroundColor(Color.RED);
            comparacaoTextModeloTamanho1.setBackgroundColor(Color.RED);
            comparacaoTextModeloResolucao2.setBackgroundColor(Color.GREEN);
            comparacaoTextModeloTamanho2.setBackgroundColor(Color.GREEN);
        }
        else{
            comparacaoTextModeloResolucao1.setBackgroundColor(Color.YELLOW);
            comparacaoTextModeloTamanho1.setBackgroundColor(Color.YELLOW);
            comparacaoTextModeloResolucao2.setBackgroundColor(Color.YELLOW);
            comparacaoTextModeloTamanho2.setBackgroundColor(Color.YELLOW);
        }
        //Set rating CAMERA
        if (celular1.notas.getCamera() > celular2.notas.getCamera()){
            comparacaoTextModeloFrontal1.setBackgroundColor(Color.GREEN);
            comparacaoTextModeloTraseira1.setBackgroundColor(Color.GREEN);
            comparacaoTextModeloFrontal2.setBackgroundColor(Color.RED);
            comparacaoTextModeloTraseira2.setBackgroundColor(Color.RED);
        }
        else if(celular1.notas.getCamera() < celular2.notas.getCamera()){
            comparacaoTextModeloFrontal1.setBackgroundColor(Color.RED);
            comparacaoTextModeloTraseira1.setBackgroundColor(Color.RED);
            comparacaoTextModeloFrontal2.setBackgroundColor(Color.GREEN);
            comparacaoTextModeloTraseira2.setBackgroundColor(Color.GREEN);
        }
        else{
            comparacaoTextModeloFrontal1.setBackgroundColor(Color.YELLOW);
            comparacaoTextModeloTraseira1.setBackgroundColor(Color.YELLOW);
            comparacaoTextModeloFrontal2.setBackgroundColor(Color.YELLOW);
            comparacaoTextModeloTraseira2.setBackgroundColor(Color.YELLOW);
        }
        //Set rating HARDWARE
        if (celular1.notas.getHardware() > celular2.notas.getHardware()){
            comparacaoTextModeloChipset1.setBackgroundColor(Color.GREEN);
            comparacaoTextModeloNucleos1.setBackgroundColor(Color.GREEN);
            comparacaoTextModeloVelocidade1.setBackgroundColor(Color.GREEN);
            comparacaoTextModeloChipset2.setBackgroundColor(Color.RED);
            comparacaoTextModeloNucleos2.setBackgroundColor(Color.RED);
            comparacaoTextModeloVelocidade2.setBackgroundColor(Color.RED);
        }
        else if(celular1.notas.getHardware() < celular2.notas.getHardware()){
            comparacaoTextModeloChipset1.setBackgroundColor(Color.RED);
            comparacaoTextModeloNucleos1.setBackgroundColor(Color.RED);
            comparacaoTextModeloVelocidade1.setBackgroundColor(Color.RED);
            comparacaoTextModeloChipset2.setBackgroundColor(Color.GREEN);
            comparacaoTextModeloNucleos2.setBackgroundColor(Color.GREEN);
            comparacaoTextModeloVelocidade2.setBackgroundColor(Color.GREEN);
        }
        else{
            comparacaoTextModeloChipset1.setBackgroundColor(Color.YELLOW);
            comparacaoTextModeloNucleos1.setBackgroundColor(Color.YELLOW);
            comparacaoTextModeloVelocidade1.setBackgroundColor(Color.YELLOW);
            comparacaoTextModeloChipset2.setBackgroundColor(Color.YELLOW);
            comparacaoTextModeloNucleos2.setBackgroundColor(Color.YELLOW);
            comparacaoTextModeloVelocidade2.setBackgroundColor(Color.YELLOW);
        }
    }
}
