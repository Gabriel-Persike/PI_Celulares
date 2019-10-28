package com.example.pi.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "SISTEMA_OPERACIONAL")

public class SISTEMA_OPERACIONAL {
    @PrimaryKey(autoGenerate = true)
    private int IDSISTEMA_OPERACIONAL;
    private String NOME_SISTEMA_OPERACIONAL;
    private String VERSOES;

    public int getIDSISTEMA_OPERACIONAL() {
        return IDSISTEMA_OPERACIONAL;
    }

    public void setIDSISTEMA_OPERACIONAL(int IDSISTEMA_OPERACIONAL) {
        this.IDSISTEMA_OPERACIONAL = IDSISTEMA_OPERACIONAL;
    }

    public String getNOME_SISTEMA_OPERACIONAL() {
        return NOME_SISTEMA_OPERACIONAL;
    }

    public void setNOME_SISTEMA_OPERACIONAL(String NOME_SISTEMA_OPERACIONAL) {
        this.NOME_SISTEMA_OPERACIONAL = NOME_SISTEMA_OPERACIONAL;
    }

    public String getVERSOES() {
        return VERSOES;
    }

    public void setVERSOES(String VERSOES) {
        this.VERSOES = VERSOES;
    }
}
