package com.example.pi.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName =  "MARCA_CELULAR")
public class Marca {
    @PrimaryKey(autoGenerate = true)
    private int  IDMARCA_CELULAR;
    private String NOME_MARCA_CELULAR;

    public Marca(String NOME_MARCA_CELULAR) {
        this.NOME_MARCA_CELULAR = NOME_MARCA_CELULAR;
    }

    public int getIDMARCA_CELULAR() {
        return IDMARCA_CELULAR;
    }

    public void setIDMARCA_CELULAR(int IDMARCA_CELULAR) {
        this.IDMARCA_CELULAR = IDMARCA_CELULAR;
    }

    public String getNOME_MARCA_CELULAR() {
        return NOME_MARCA_CELULAR;
    }

    public void setNOME_MARCA_CELULAR(String NOME_MARCA_CELULAR) {
        this.NOME_MARCA_CELULAR = NOME_MARCA_CELULAR;
    }
}
