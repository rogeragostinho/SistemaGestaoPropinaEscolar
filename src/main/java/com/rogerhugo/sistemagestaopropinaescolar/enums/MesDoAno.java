package com.rogerhugo.sistemagestaopropinaescolar.enums;

public enum MesDoAno {
    JANEIRO(1, "janeiro"),
    FEVEREIRO(2, "fevereiro"),
    MARCO(3, "março"),
    ABRIL(4, "abril"),
    MAIO(5, "maio"),
    JUNHO(6, "junho"),
    JULHO(7, "julho"),
    AGOSTO(8, "agosto"),
    SETEMBRO(9, "setembro"),
    OUTUBRO(10, "outubro"),
    NOVEMBRO(11, "novembro"),
    DEZEMBRO(12, "dezembro");

    private final int numero;
    private final String nome;

    private MesDoAno(int numero, String nome) {
        this.numero = numero;
        this.nome = nome;
    }

    public static MesDoAno mesDoAnoByNumero(int numero) {
        for (MesDoAno mesDoAno: values())
            if (mesDoAno.getNumero() == numero)
                return mesDoAno;

        return null;
    }

    public static MesDoAno mesDoAnoByNome(String nome) {
        for (MesDoAno mesDoAno: values())
            if (mesDoAno.getNome().equals(nome))
                return mesDoAno;

        return null;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }
}
