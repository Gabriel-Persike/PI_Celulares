package com.example.pi.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Notas_celular")
public class Notas  {
    @PrimaryKey(autoGenerate = true)
    private int IDNOTAS;
    private double Hardware;
    private double Desempenho;
    private double Custo_Beneficio;
    private double Tela;
    private double Camera;

    public Notas(double hardware, double desempenho, double custo_Beneficio, double tela, double camera) {
        Hardware = hardware;
        Desempenho = desempenho;
        Custo_Beneficio = custo_Beneficio;
        Tela = tela;
        Camera = camera;
    }

    public int getIDNOTAS() {
        return IDNOTAS;
    }

    public void setIDNOTAS(int IDNOTAS) {
        this.IDNOTAS = IDNOTAS;
    }

    public double getHardware() {
        return Hardware;
    }

    public void setHardware(double hardware) {
        Hardware = hardware;
    }

    public double getDesempenho() {
        return Desempenho;
    }

    public void setDesempenho(double desempenho) {
        Desempenho = desempenho;
    }

    public double getCusto_Beneficio() {
        return Custo_Beneficio;
    }

    public void setCusto_Beneficio(double custo_Beneficio) {
        Custo_Beneficio = custo_Beneficio;
    }

    public double getTela() {
        return Tela;
    }

    public void setTela(double tela) {
        Tela = tela;
    }

    public double getCamera() {
        return Camera;
    }

    public void setCamera(double camera) {
        Camera = camera;
    }
}
