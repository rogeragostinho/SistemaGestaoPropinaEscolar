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
        return repository.create(t);
    }

    @Override
    public List<T> pegarTodos() {
        return repository.findAll();
    }

    @Override
    public T pegar(int id) {
        return (T) repository.findById(id);
    }

    @Override
    public boolean eliminar(int id) {
        return repository.delete(id);
    }

    @Override
    public boolean atualizar(int id, T t) {
        return repository.update(id, t);
    }
}
