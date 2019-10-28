package com.example.pi.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TELA")
public class TELA {
    @PrimaryKey(autoGenerate = true)
    private int IDTELA;
    private int TAMANHO_TELA;
    private int RESOLUCAO_TELA;

    public TELA(int ITELA, int TAMANHO_TELA, int RESOLUCAO_TELA) {
        this.IDTELA = ITELA;
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

    public int getTAMANHO_TELA() {
        return TAMANHO_TELA;
    }

    public void setTAMANHO_TELA(int TAMANHO_TELA) {
        this.TAMANHO_TELA = TAMANHO_TELA;
    }

    public int getRESOLUCAO_TELA() {
        return RESOLUCAO_TELA;
    }

    public void setRESOLUCAO_TELA(int RESOLUCAO_TELA) {
        this.RESOLUCAO_TELA = RESOLUCAO_TELA;
    }


}
