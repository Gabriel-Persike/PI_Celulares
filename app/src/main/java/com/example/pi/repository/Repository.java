package com.example.pi.repository;

import android.content.Context;

public class Repository {
private CameraRepository cameraRepository;
private CelularRepository celularRepository;
private MarcaRepository marcaRepository;
private ProcessadorRepository processadorRepository;
private Sistema_OperacionaRepository soRepository;
private TelaRepository telaRepository;


    public Repository(Context context){
        cameraRepository = new CameraRepository(context);
        celularRepository = new CelularRepository(context);
        marcaRepository = new MarcaRepository(context);
        processadorRepository = new ProcessadorRepository(context);
        soRepository = new Sistema_OperacionaRepository(context);
        telaRepository = new TelaRepository(context);
    }

    public CameraRepository getCameraRepository() {
        return cameraRepository;
    }

    public CelularRepository getCelularRepository() {
        return celularRepository;
    }

    public MarcaRepository getMarcaRepository() {
        return marcaRepository;
    }

    public ProcessadorRepository getProcessadorRepository() {
        return processadorRepository;
    }

    public Sistema_OperacionaRepository getSoRepository() {
        return soRepository;
    }

    public TelaRepository getTelaRepository() {
        return telaRepository;
    }
}
