package com.rogerhugo.sistemagestaopropinaescolar.repository;

import java.util.List;

public interface GenericRepository<T> {
    boolean create(T t);
    T find(int id);
    List<T> findAll();
    boolean update(int id, T t);
    boolean delete(int id);
    <U> List<T> search(String field, U value);
    <U> T findBy(String field, U value);
    <U> List<T> findAllBy(String field, U value);
}
