package com.example.pi.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pi.Model.TELA;

import java.util.List;

public class TelaAdapter extends ArrayAdapter<TELA> {
    private int rId;

    public TelaAdapter(Context context, int resource, List<TELA> objects){
        super(context, resource, objects);
        rId = resource;
    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent){
        TELA tela = getItem(position);
        TextView textTela = (TextView) super.getView(position, currentView, parent);
        textTela.setText("Tamanho: " + tela.getTAMANHO_TELA() + " Resolução: " + tela.getRESOLUCAO_TELA());
        return textTela;
    }

    @Override
    public View getDropDownView(int position, View currentView, ViewGroup parent){
        TELA tela = getItem(position);
        TextView label = (TextView) super.getDropDownView(position, currentView, parent);
        label.setText("Tamanho: " + tela.getTAMANHO_TELA() + " Resolução: " + tela.getRESOLUCAO_TELA());
        return label;
    }
}
