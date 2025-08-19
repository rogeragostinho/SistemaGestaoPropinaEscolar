package com.rogerhugo.sistemagestaopropinaescolar.model;

public class Usuario {
    private int id;
    private String tipo;
    private String nome;
    private String senha;

    public Usuario(String tipo, String nome, String senha) {
        this.senha = senha;
        this.nome = nome;
        this.tipo = tipo;
    }

    public Usuario(int id, String tipo, String nome, String senha) {
        this.id = id;
        this.senha = senha;
        this.nome = nome;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
