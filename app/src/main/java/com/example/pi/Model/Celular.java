package com.example.pi.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "TCEL", foreignKeys = @ForeignKey(entity = Marca.class,
                                            parentColumns = "ID",
                                            childColumns = "marcaId"))

public class Celular {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private int id;
    private String nome;
    private double preco;
    private int anoProducao;
    private int marcaId;

    public Celular(){

    }

    public Celular(String nome, double preco, int anoProducao, int marcaId) {
        this.nome = nome;
        this.preco = preco;
        this.anoProducao = anoProducao;
        this.marcaId = marcaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getAnoProducao() {
        return anoProducao;
    }

    public void setAnoProducao(int anoProducao) {
        this.anoProducao = anoProducao;
    }

    public int getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(int marcaId) {
        this.marcaId = marcaId;
    }
}
