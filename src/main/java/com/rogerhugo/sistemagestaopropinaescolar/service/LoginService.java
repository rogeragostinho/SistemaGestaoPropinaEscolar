package com.rogerhugo.sistemagestaopropinaescolar.service;

import com.rogerhugo.sistemagestaopropinaescolar.model.Usuario;
import com.rogerhugo.sistemagestaopropinaescolar.repository.UsuarioRepository;

public class LoginService extends AbstractService<Usuario, UsuarioRepository>{
    private Usuario user;
    private static final LoginService instance = new LoginService();

    private LoginService() {
        super(UsuarioRepository.getInstance());
    }

    public static LoginService getInstance() {
        return instance;
    }

    public boolean login(String nome, String senha) {
        this.user = repository.findByNomeAndSenha(nome, senha);
        return this.user != null;
    }

    public boolean logout() {
        this.user = null;
        return true;
    }

    public Usuario getUser() {
        return this.user;
    }
}
