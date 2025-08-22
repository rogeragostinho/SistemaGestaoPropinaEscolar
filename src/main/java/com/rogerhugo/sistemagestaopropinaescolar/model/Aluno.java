package com.rogerhugo.sistemagestaopropinaescolar.model;

public class Aluno {
    private int id;
    private String nome;
    private String turma;
    private String classe;
    private String curso;

    public Aluno() {}

    public Aluno(String nome, String classe, String curso, String turma) {
        this.curso = curso;
        this.classe = classe;
        this.turma = turma;
        this.nome = nome;
    }

    public Aluno(int id, String nome, String classe, String curso, String turma) {
        this(nome, classe, curso, turma);
        this.id = id;
    }

    public Aluno(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", turma='" + turma + '\'' +
                ", classe='" + classe + '\'' +
                ", curso='" + curso + '\'' +
                '}';
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

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
