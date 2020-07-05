package com.example.pi.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TELA")
public class TELA {
    @PrimaryKey(autoGenerate = true)
    private int IDTELA;
    private float TAMANHO_TELA;
    private String RESOLUCAO_TELA;

    public TELA(float TAMANHO_TELA, String RESOLUCAO_TELA) {
        this.TAMANHO_TELA = TAMANHO_TELA;
        this.RESOLUCAO_TELA = RESOLUCAO_TELA;
    }

    public TELA(){

    }

    public int getIDTELA() {
        return IDTELA;
    }

    public void setIDTELA(int IDTELA) {
        this.IDTELA = IDTELA;
    }

    public float getTAMANHO_TELA() {
        return TAMANHO_TELA;
    }

    public void setTAMANHO_TELA(float TAMANHO_TELA) {
        this.TAMANHO_TELA = TAMANHO_TELA;
    }

    public String getRESOLUCAO_TELA() {
        return RESOLUCAO_TELA;
    }

    public void setRESOLUCAO_TELA(String RESOLUCAO_TELA) {
        this.RESOLUCAO_TELA = RESOLUCAO_TELA;
    }


}
