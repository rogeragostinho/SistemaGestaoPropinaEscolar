package com.rogerhugo.sistemagestaopropinaescolar.model;

public class Curso {
    private int id;
    private String nome;
    private double valorPropina;

    public Curso(int id, String nome, double valorPropina) {
        this.id = id;
        this.nome = nome;
        this.valorPropina = valorPropina;
    }

    public Curso(String nome, double valorPropina) {
        this.valorPropina = valorPropina;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorPropina() {
        return valorPropina;
    }

    public void setValorPropina(double valorPropina) {
        this.valorPropina = valorPropina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
