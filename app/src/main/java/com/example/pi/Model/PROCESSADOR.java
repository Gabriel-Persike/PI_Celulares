package com.example.pi.Model;

import androidx.room.Entity;

@Entity(tableName = "PROCESSADOR")
public class PROCESSADOR {
    private int IDPROCESSADOR;
    private String CHIPSET;
    private int NR_NUCLEOS;
    private int NR_VELOCIDADE;

    public PROCESSADOR(int IDPROCESSADOR, String CHIPSET, int NR_NUCLEOS, int NR_VELOCIDADE) {
        this.IDPROCESSADOR = IDPROCESSADOR;
        this.CHIPSET = CHIPSET;
        this.NR_NUCLEOS = NR_NUCLEOS;
        this.NR_VELOCIDADE = NR_VELOCIDADE;
    }

    public int getIDPROCESSADOR() {
        return IDPROCESSADOR;
    }

    public void setIDPROCESSADOR(int IDPROCESSADOR) {
        this.IDPROCESSADOR = IDPROCESSADOR;
    }

    public String getCHIPSET() {
        return CHIPSET;
    }

    public void setCHIPSET(String CHIPSET) {
        this.CHIPSET = CHIPSET;
    }

    public int getNR_NUCLEOS() {
        return NR_NUCLEOS;
    }

    public void setNR_NUCLEOS(int NR_NUCLEOS) {
        this.NR_NUCLEOS = NR_NUCLEOS;
    }

    public int getNR_VELOCIDADE() {
        return NR_VELOCIDADE;
    }

    public void setNR_VELOCIDADE(int NR_VELOCIDADE) {
        this.NR_VELOCIDADE = NR_VELOCIDADE;
    }
}
