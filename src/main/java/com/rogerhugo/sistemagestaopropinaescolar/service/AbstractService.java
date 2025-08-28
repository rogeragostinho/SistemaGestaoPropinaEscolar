package com.rogerhugo.sistemagestaopropinaescolar.service;

import com.rogerhugo.sistemagestaopropinaescolar.repository.AbstractRepository;

import java.util.List;

public abstract class AbstractService<T, R extends AbstractRepository<T>> implements GenericService<T> {
    protected R repository;

    protected AbstractService(R repository) {
        this.repository = repository;
    }

    @Override
    public boolean registar(T t) {
        if (t == null) throw new IllegalArgumentException("Entidade não pode ser nula.");
        return repository.create(t);
    }

    @Override
    public List<T> pegarTodos() {
        return repository.findAll();
    }

    @Override
    public T pegar(int id) {
        if (id < 1) throw new IllegalArgumentException("O id deve ser um número positivo, diferente de 0.");
        return repository.find(id);
    }

    @Override
    public boolean eliminar(int id) {
        if (id < 1) throw new IllegalArgumentException("O id deve ser um número positivo, diferente de 0.");
        return repository.delete(id);
    }

    @Override
    public boolean atualizar(int id, T t) {
        if (id < 1) throw new IllegalArgumentException("O id deve ser um número positivo, diferente de 0.");
        return repository.update(id, t);
    }

    @Override
    public <U> List<T> pesquisar(String campo, U valor) {
        if (campo.equals("")) throw new IllegalArgumentException("O campo não pode ser vazio.");
        if (valor == null) throw new IllegalArgumentException("O valor deve conter alguma coisa.");
        return repository.search(campo, valor);
    }

    @Override
    public <U> List<T> pegarTodosPelo(String campo, U valor) {
        if (campo.equals("")) throw new IllegalArgumentException("O campo não pode ser vazio.");
        if (valor == null) throw new IllegalArgumentException("O valor deve conter alguma coisa.");
        return repository.findAllBy(campo, valor);
    }

    @Override
    public <U> T pegarPelo(String campo, U valor) {
        if (campo.equals("")) throw new IllegalArgumentException("O campo não pode ser vazio.");
        if (valor == null) throw new IllegalArgumentException("O valor deve conter alguma coisa.");
        return repository.findBy(campo, valor);
    }
}
