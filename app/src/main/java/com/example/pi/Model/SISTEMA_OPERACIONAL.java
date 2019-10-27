package com.example.pi.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "SISTEMA_OPERACIONAL")

public class SISTEMA_OPERACIONAL {
    @PrimaryKey(autoGenerate = true)
    private int IDSISTEMA_OPERACIONAL;
    private String NOME_SISTEMA_OPERACIONAL;
    private String VERSOES;
}
