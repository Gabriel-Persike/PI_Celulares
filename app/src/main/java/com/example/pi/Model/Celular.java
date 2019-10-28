package com.example.pi.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "MODELO_CELULAR", foreignKeys = {@ForeignKey(entity = Marca.class,
                                            parentColumns = "IDMARCA_CELULAR",
                                            childColumns = "MARCA_CELULAR_IDMARCA_CELULAR"),
                                           @ForeignKey(entity = SISTEMA_OPERACIONAL.class,
                                           parentColumns = "IDSISTEMA_OPERACIONAL",
                                           childColumns = "SISTEMA_OPERACIONAL_IDSISTEMA_OPERACIONAL"),
                                            @ForeignKey(entity = PROCESSADOR.class,
                                            parentColumns = "IDPROCESSADOR",
                                            childColumns = "PROCESSADOR_IDPROCESSADOR"),
                                            @ForeignKey(entity = CAMERA.class,
                                            parentColumns = "IDCAMERA",
                                            childColumns = "CAMERA_IDCAMERA"),
                                            @ForeignKey(entity = TELA.class,
                                            parentColumns = "IDTELA",
                                            childColumns = "TELA_IDTELA")
}
)

public class Celular {
    @PrimaryKey(autoGenerate = true)
    private int IDMODELO_CELULAR;
    private int TELA_IDTELA;
    private int PROCESSADOR_IDPROCESSADOR;
    private int MARCA_CELULAR_IDMARCA_CELULAR;
    private int SISTEMA_OPERACIONAL_IDSISTEMA_OPERACIONAL;
    private int CAMERA_IDCAMERA;
    private String MODELO_CELULAR;
    private int MEMORIA_RAM;
    private int MEMORIA;
    private int PRECO;


    @Ignore
    public Celular(){

    }

    public Celular(int TELA_IDTELA, int PROCESSADOR_IDPROCESSADOR, int MARCA_CELULAR_IDMARCA_CELULAR, int SISTEMA_OPERACIONAL_IDSISTEMA_OPERACIONAL, int CAMERA_IDCAMERA, String MODELO_CELULAR, int MEMORIA_RAM, int MEMORIA, int PRECO) {
        this.TELA_IDTELA = TELA_IDTELA;
        this.PROCESSADOR_IDPROCESSADOR = PROCESSADOR_IDPROCESSADOR;
        this.MARCA_CELULAR_IDMARCA_CELULAR = MARCA_CELULAR_IDMARCA_CELULAR;
        this.SISTEMA_OPERACIONAL_IDSISTEMA_OPERACIONAL = SISTEMA_OPERACIONAL_IDSISTEMA_OPERACIONAL;
        this.CAMERA_IDCAMERA = CAMERA_IDCAMERA;
        this.MODELO_CELULAR = MODELO_CELULAR;
        this.MEMORIA_RAM = MEMORIA_RAM;
        this.MEMORIA = MEMORIA;
        this.PRECO = PRECO;
    }

    public int getCAMERA_IDCAMERA() {
        return CAMERA_IDCAMERA;
    }

    public void setCAMERA_IDCAMERA(int CAMERA_IDCAMERA) {
        this.CAMERA_IDCAMERA = CAMERA_IDCAMERA;
    }

    public int getIDMODELO_CELULAR() {
        return IDMODELO_CELULAR;
    }

    public void setIDMODELO_CELULAR(int IDMODELO_CELULAR) {
        this.IDMODELO_CELULAR = IDMODELO_CELULAR;
    }

    public int getTELA_IDTELA() {
        return TELA_IDTELA;
    }

    public void setTELA_IDTELA(int TELA_IDTELA) {
        this.TELA_IDTELA = TELA_IDTELA;
    }

    public int getPROCESSADOR_IDPROCESSADOR() {
        return PROCESSADOR_IDPROCESSADOR;
    }

    public void setPROCESSADOR_IDPROCESSADOR(int PROCESSADOR_IDPROCESSADOR) {
        this.PROCESSADOR_IDPROCESSADOR = PROCESSADOR_IDPROCESSADOR;
    }

    public int getMARCA_CELULAR_IDMARCA_CELULAR() {
        return MARCA_CELULAR_IDMARCA_CELULAR;
    }

    public void setMARCA_CELULAR_IDMARCA_CELULAR(int MARCA_CELULAR_IDMARCA_CELULAR) {
        this.MARCA_CELULAR_IDMARCA_CELULAR = MARCA_CELULAR_IDMARCA_CELULAR;
    }

    public int getSISTEMA_OPERACIONAL_IDSISTEMA_OPERACIONAL() {
        return SISTEMA_OPERACIONAL_IDSISTEMA_OPERACIONAL;
    }

    public void setSISTEMA_OPERACIONAL_IDSISTEMA_OPERACIONAL(int SISTEMA_OPERACIONAL_IDSISTEMA_OPERACIONAL) {
        this.SISTEMA_OPERACIONAL_IDSISTEMA_OPERACIONAL = SISTEMA_OPERACIONAL_IDSISTEMA_OPERACIONAL;
    }

    public String getMODELO_CELULAR() {
        return MODELO_CELULAR;
    }

    public void setMODELO_CELULAR(String MODELO_CELULAR) {
        this.MODELO_CELULAR = MODELO_CELULAR;
    }

    public int getMEMORIA_RAM() {
        return MEMORIA_RAM;
    }

    public void setMEMORIA_RAM(int MEMORIA_RAM) {
        this.MEMORIA_RAM = MEMORIA_RAM;
    }

    public int getMEMORIA() {
        return MEMORIA;
    }

    public void setMEMORIA(int MEMORIA) {
        this.MEMORIA = MEMORIA;
    }

    public int getPRECO() {
        return PRECO;
    }

    public void setPRECO(int PRECO) {
        this.PRECO = PRECO;
    }
}
