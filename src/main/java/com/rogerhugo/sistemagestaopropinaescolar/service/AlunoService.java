package com.rogerhugo.sistemagestaopropinaescolar.service;

import com.rogerhugo.sistemagestaopropinaescolar.model.Aluno;
import com.rogerhugo.sistemagestaopropinaescolar.repository.AlunoRepository;

import java.util.List;

public class AlunoService {
    private static AlunoService instance = new AlunoService();
    private AlunoRepository repository;

    private AlunoService() {
        repository = AlunoRepository.getInstance();
    }

    public static AlunoService getInstance() {
        return instance;
    }

    public boolean registrar(Aluno aluno) {
        return repository.create(aluno);
    }

    public List<Aluno> pegarTodos() {
        return repository.findAll();
    }

    public Aluno pegar(int id) {
        return repository.findById(id);
    }

    public boolean eliminar(Integer id) {
        return repository.delete(id);
    }

    public boolean atualizar(int id, Aluno aluno) {
        return repository.update(id, aluno);
    }

    public Aluno pesquisar(String nome) {
        return null;
    }
}
