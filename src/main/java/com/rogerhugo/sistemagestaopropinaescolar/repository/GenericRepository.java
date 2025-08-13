package com.rogerhugo.sistemagestaopropinaescolar.repository;

import java.util.List;

public interface GenericRepository<T> {
    boolean create(T t);
    T findById(int id);
    List<T> findAll();
    boolean update(int id, T t);
    boolean delete(int id);
}
