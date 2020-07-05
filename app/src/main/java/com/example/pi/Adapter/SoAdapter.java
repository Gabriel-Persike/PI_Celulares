package com.example.pi.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pi.Model.SISTEMA_OPERACIONAL;

import java.util.List;

public class SoAdapter extends ArrayAdapter<SISTEMA_OPERACIONAL> {
    private int rId;

    public SoAdapter(Context context, int resource, List<SISTEMA_OPERACIONAL> objects){
        super(context, resource, objects);
        rId = resource;
    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent){
        SISTEMA_OPERACIONAL so = getItem(position);
        TextView textSo = (TextView) super.getView(position, currentView, parent);
        textSo.setText("SO: " + so.getNOME_SISTEMA_OPERACIONAL() + " Versão: " + so.getVERSOES());
        return textSo;
    }

    @Override
    public View getDropDownView(int position, View currentView, ViewGroup parent){
        SISTEMA_OPERACIONAL so = getItem(position);
        TextView label = (TextView) super.getDropDownView(position, currentView, parent);
        label.setText("SO: " + so.getNOME_SISTEMA_OPERACIONAL() + " Versão: " + so.getVERSOES());
        return label;
    }
}
