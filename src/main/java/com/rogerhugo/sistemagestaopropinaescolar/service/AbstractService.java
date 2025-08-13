package com.rogerhugo.sistemagestaopropinaescolar.service;

import com.rogerhugo.sistemagestaopropinaescolar.repository.GenericRepository;

public abstract class AbstractService<T> implements GenericService<T> {
    private GenericRepository repository;
}
