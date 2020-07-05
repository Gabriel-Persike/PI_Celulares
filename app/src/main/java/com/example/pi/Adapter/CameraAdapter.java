package com.example.pi.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pi.Model.CAMERA;

import java.util.List;

public class CameraAdapter extends ArrayAdapter<CAMERA> {
    private int rId;

    public CameraAdapter(Context context, int resource, List<CAMERA> objects){
        super(context, resource, objects);
        rId = resource;
    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent){
        CAMERA camera = getItem(position);
        TextView textCamera =(TextView) super.getView(position, currentView, parent);
        textCamera.setText("Camera frontal: " + camera.getCAMERA_FRONTAL() + " Camera traseira: " + camera.getCAMERA_TRASEIRA());
        return textCamera;
    }

    @Override
    public View getDropDownView(int position, View currentView, ViewGroup parent){
        CAMERA camera = getItem(position);
        TextView label = (TextView) super.getDropDownView(position, currentView, parent);
        label.setText("Camera frontal: " + camera.getCAMERA_FRONTAL() + " Camera traseira: " + camera.getCAMERA_TRASEIRA());
        return label;
    }

}
