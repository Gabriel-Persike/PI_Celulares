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
                                            childColumns = "TELA_IDTELA"),
                                            @ForeignKey(entity = Notas.class,
                                            parentColumns = "IDNOTAS",
                                            childColumns = "NOTAS_IDNOTAS")
}
)

public class Celular {
    @PrimaryKey(autoGenerate = true)
    private int IDMODELO_CELULAR;
    private int TELA_IDTELA;
    private int PROCESSADOR_IDPROCESSADOR;
    private int MARCA_CELULAR_IDMARCA_CELULAR;
    private int NOTAS_IDNOTAS;
    private int SISTEMA_OPERACIONAL_IDSISTEMA_OPERACIONAL;
    private int CAMERA_IDCAMERA;
    private String MODELO_CELULAR;
    private int MEMORIA_RAM;
    private int MEMORIA;
    private float PRECO;


    @Ignore
    public Celular(){

    }

    public int getNOTAS_IDNOTAS() {
        return NOTAS_IDNOTAS;
    }

    public void setNOTAS_IDNOTAS(int NOTAS_IDNOTAS) {
        this.NOTAS_IDNOTAS = NOTAS_IDNOTAS;
    }

    public Celular(int TELA_IDTELA, int PROCESSADOR_IDPROCESSADOR, int MARCA_CELULAR_IDMARCA_CELULAR, int NOTAS_IDNOTAS, int SISTEMA_OPERACIONAL_IDSISTEMA_OPERACIONAL, int CAMERA_IDCAMERA, String MODELO_CELULAR, int MEMORIA_RAM, int MEMORIA, float PRECO) {
        this.TELA_IDTELA = TELA_IDTELA;
        this.PROCESSADOR_IDPROCESSADOR = PROCESSADOR_IDPROCESSADOR;
        this.MARCA_CELULAR_IDMARCA_CELULAR = MARCA_CELULAR_IDMARCA_CELULAR;
        this.NOTAS_IDNOTAS = NOTAS_IDNOTAS;
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

    public float getPRECO() {
        return PRECO;
    }

    public void setPRECO(float PRECO) {
        this.PRECO = PRECO;
    }

    public String isPreenchido(){
        if (MODELO_CELULAR == null || MODELO_CELULAR == ""){
            return "Modelo do celular não preenchido.";
        }
        else if(MEMORIA_RAM == 0){
            return "Memoria RAM do celular não preenchido.";
        }
        else if(MEMORIA == 0){
            return "Armazenamento do celular não preenchido.";
        }
        else if(PRECO == 0){
            return "Preço do celular não preenchido.";
        }
        else if(CAMERA_IDCAMERA == 0){
            return "Camera do celular não preenchido.";
        }
        else if(SISTEMA_OPERACIONAL_IDSISTEMA_OPERACIONAL == 0){
            return "Sistema operacional do celular não preenchido.";
        }
        else if(MARCA_CELULAR_IDMARCA_CELULAR == 0){
            return "Marca do celular não preenchido.";
        }
        else if(PROCESSADOR_IDPROCESSADOR == 0){
            return "Processador do celular não preenchido.";
        }
        else if(TELA_IDTELA == 0){
            return "Tela do celular não preenchido.";
        }
        else{
            return "";
        }
    }
}
