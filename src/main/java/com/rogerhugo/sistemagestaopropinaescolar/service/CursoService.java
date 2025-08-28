package com.rogerhugo.sistemagestaopropinaescolar.service;

import com.rogerhugo.sistemagestaopropinaescolar.model.Curso;
import com.rogerhugo.sistemagestaopropinaescolar.repository.CursoRepository;

public class CursoService extends AbstractService<Curso, CursoRepository> {
    private static CursoService instance;

    private CursoService() {
        super(CursoRepository.getInstance());
    }

    public static CursoService getInstance() {
        if (instance == null) instance = new CursoService();
        return instance;
    }
}
