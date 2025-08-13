package com.rogerhugo.sistemagestaopropinaescolar.service;

import com.rogerhugo.sistemagestaopropinaescolar.model.Aluno;
import com.rogerhugo.sistemagestaopropinaescolar.repository.AlunoRepository;

public class AlunoService extends AbstractService<Aluno, AlunoRepository> {
    private static AlunoService instance = new AlunoService();

    private AlunoService() {
        super(AlunoRepository.getInstance());
    }

    public static AlunoService getInstance() {
        return instance;
    }

    public Aluno pesquisar(String nome) {
        return null;
    }
}
