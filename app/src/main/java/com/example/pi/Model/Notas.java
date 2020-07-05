package com.example.pi.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Notas_celular")
public class Notas  {
    @PrimaryKey(autoGenerate = true)
    private int IDNOTAS;
    private float Hardware;
    private float Desempenho;
    private float Custo_Beneficio;
    private float Tela;
    private float Camera;

    public Notas(){
    }

    public Notas(float hardware, float desempenho, float custo_Beneficio, float tela, float camera) {
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

    public float getHardware() {
        return Hardware;
    }

    public void setHardware(float hardware) {
        Hardware = hardware;
    }

    public float getDesempenho() {
        return Desempenho;
    }

    public void setDesempenho(float desempenho) {
        Desempenho = desempenho;
    }

    public float getCusto_Beneficio() {
        return Custo_Beneficio;
    }

    public void setCusto_Beneficio(float custo_Beneficio) {
        Custo_Beneficio = custo_Beneficio;
    }

    public float getTela() {
        return Tela;
    }

    public void setTela(float tela) {
        Tela = tela;
    }

    public float getCamera() {
        return Camera;
    }

    public void setCamera(float camera) {
        Camera = camera;
    }
}
