package com.example.pi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.pi.DAO.CelularDAO;
import com.example.pi.R;

import java.util.List;

public class CelularAdapter extends ArrayAdapter<CelularDAO.CelularJoin> {

    private int rId;

    public CelularAdapter(@NonNull Context context, int resource, @NonNull List<CelularDAO.CelularJoin> objects) {
        super(context, resource, objects);
        rId = resource;
    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent){
        View mView = currentView;

        if(mView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(rId,null);
        }

        CelularDAO.CelularJoin celularJoin = getItem(position);

        TextView textModelo = mView.findViewById(R.id.textModeloCelular);
        TextView textPreco = mView.findViewById(R.id.textPrecoCelular);
        TextView textMemoria = mView.findViewById(R.id.textMemoriaCelular);
        TextView textArmazenamento = mView.findViewById(R.id.textArmazenamentoCelular);
        TextView textProcessador = mView.findViewById(R.id.textProcessadorCelular);
        TextView textSo = mView.findViewById(R.id.textSoCelular);
        TextView textTela = mView.findViewById(R.id.textTelaCelular);
        TextView textCamera = mView.findViewById(R.id.textCameraCelular);
        TextView textMarca = mView.findViewById(R.id.textMarcaCelular);

        textModelo.setText(celularJoin.celular.getMODELO_CELULAR());
        textPreco.setText(String.valueOf(celularJoin.celular.getPRECO()));
        textMemoria.setText(String.valueOf(celularJoin.celular.getMEMORIA_RAM()));
        textArmazenamento.setText(String.valueOf(celularJoin.celular.getMEMORIA()));
        textProcessador.setText("Chipset:" + celularJoin.processador.getCHIPSET() + " Nucleos: " + String.valueOf(celularJoin.processador.getNR_NUCLEOS()) + " Velocidade: " + String.valueOf(celularJoin.processador.getNR_VELOCIDADE()));
        textModelo.setText(celularJoin.celular.getMODELO_CELULAR());
        textSo.setText("SO: " + celularJoin.so.getNOME_SISTEMA_OPERACIONAL() + " Versão: " + celularJoin.so.getVERSOES());
        textTela.setText("Tamanho: " + String.valueOf(celularJoin.tela.getTAMANHO_TELA()) + " Resolução: " + celularJoin.tela.getRESOLUCAO_TELA());
        textCamera.setText("Frontal: " + celularJoin.camera.getCAMERA_FRONTAL() + " Traseira: " + celularJoin.camera.getCAMERA_TRASEIRA());
        textMarca.setText(celularJoin.marca.getNOME_MARCA_CELULAR());
        return mView;
    }
}
