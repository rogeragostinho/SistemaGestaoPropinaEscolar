package com.rogerhugo.sistemagestaopropinaescolar.service;

import com.rogerhugo.sistemagestaopropinaescolar.model.Usuario;
import com.rogerhugo.sistemagestaopropinaescolar.repository.UsuarioRepository;

public class UsuarioService extends AbstractService<Usuario, UsuarioRepository> {
    private static UsuarioService instance = new UsuarioService();

    private UsuarioService() {
        super(UsuarioRepository.getInstance());
    }

    public static UsuarioService getInstance() {
        return instance;
    }

    public Usuario findByNome(String nome) {
        return repository.findByNome("Róger");
    }
}
