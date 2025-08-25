package com.rogerhugo.sistemagestaopropinaescolar.service;

import com.rogerhugo.sistemagestaopropinaescolar.model.Aluno;
import com.rogerhugo.sistemagestaopropinaescolar.repository.AlunoRepository;

import java.util.List;

public class AlunoService extends AbstractService<Aluno, AlunoRepository> {
    private static AlunoService instance = new AlunoService();

    private AlunoService() {
        super(AlunoRepository.getInstance());
    }

    public static AlunoService getInstance() {
        return instance;
    }

    public List<Aluno> pesquisar(String nome) {
        return repository.search("nome", nome);
    }
}
