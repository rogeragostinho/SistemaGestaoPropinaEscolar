package com.rogerhugo.sistemagestaopropinaescolar.model;

import java.util.Date;

public class Pagamento {
    private int id;
    private Date data;
    private double valor;
    private int mesLetivo; //enum
    private int anoLetivo;
    private int idAluno;

    public Pagamento(int id, int idAluno, int anoLetivo, int mesLetivo, double valor, Date data) {
        this.id = id;
        this.idAluno = idAluno;
        this.anoLetivo = anoLetivo;
        this.mesLetivo = mesLetivo;
        this.valor = valor;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "id=" + id +
                ", data=" + data +
                ", valor=" + valor +
                ", mesLetivo=" + mesLetivo +
                ", anoLetivo=" + anoLetivo +
                ", idAluno=" + idAluno +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(int anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public int getMesLetivo() {
        return mesLetivo;
    }

    public void setMesLetivo(int mesLetivo) {
        this.mesLetivo = mesLetivo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
