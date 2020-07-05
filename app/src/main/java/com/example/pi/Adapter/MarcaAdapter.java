package com.example.pi.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pi.Model.Marca;

import java.util.List;

public class MarcaAdapter extends ArrayAdapter<Marca> {
    private int rId;

public MarcaAdapter(Context context, int resource, List<Marca> objects){
    super(context, resource, objects);
    rId = resource;
}

@Override
    public View getView(int position, View currentView, ViewGroup parent){
    Marca marca = getItem(position);
    TextView textMarca =(TextView) super.getView(position, currentView, parent);
    textMarca.setText(marca.getNOME_MARCA_CELULAR());
    return textMarca;
}

@Override
public View getDropDownView(int position, View currentView, ViewGroup parent){
    Marca marca = getItem(position);
    TextView label = (TextView) super.getDropDownView(position, currentView, parent);
    label.setText(marca.getNOME_MARCA_CELULAR());
    return label;
}
}
