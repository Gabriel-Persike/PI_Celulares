package com.example.pi.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pi.Model.PROCESSADOR;

import org.w3c.dom.Text;

import java.util.List;

public class ProcessadorAdapter extends ArrayAdapter<PROCESSADOR> {
    private int rId;

    public ProcessadorAdapter(Context context,int resource, List<PROCESSADOR> objects){
        super(context, resource, objects);
        rId = resource;
    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent){
        PROCESSADOR processador = getItem(position);
        TextView textProcessador = (TextView) super.getView(position, currentView, parent);
        textProcessador.setText("Chipset: " + processador.getCHIPSET() + " Nucleos: " + processador.getNR_NUCLEOS() + " Velocidade: " + processador.getNR_VELOCIDADE());
        return textProcessador;
    }

    @Override
    public View getDropDownView(int position, View currentView, ViewGroup parent){
        PROCESSADOR processador = getItem(position);
        TextView label = (TextView) super.getDropDownView(position, currentView, parent);
        label.setText("Chipset: " + processador.getCHIPSET() + " Nucleos: " + processador.getNR_NUCLEOS() + " Velocidade: " + processador.getNR_VELOCIDADE());
        return label;
    }
}
