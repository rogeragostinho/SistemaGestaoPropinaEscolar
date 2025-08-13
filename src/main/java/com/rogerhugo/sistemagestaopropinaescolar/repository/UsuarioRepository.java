package com.rogerhugo.sistemagestaopropinaescolar.repository;

import com.rogerhugo.sistemagestaopropinaescolar.db.ConnectionFactory;
import com.rogerhugo.sistemagestaopropinaescolar.model.Usuario;

import java.sql.*;

public class UsuarioRepository extends AbstractRepository<Usuario> {
    private static UsuarioRepository instance = new UsuarioRepository();

    private UsuarioRepository() {
        super("usuarios", "tipo, nome, senha");
    }

    public static UsuarioRepository getInstance() {
        return instance;
    }

    protected void setCreateStatement(PreparedStatement ps, Usuario usuario) throws SQLException {
        ps.setString(1, usuario.getTipo());
        ps.setString(2, usuario.getNome());
        ps.setString(3, usuario.getSenha());
    }

    @Override
    protected Usuario mapResultSet(ResultSet rs) throws SQLException {
        return new Usuario(rs.getInt("id"), rs.getString("tipo"), rs.getString("nome"), rs.getString("senha"));
    }

    public Usuario findByNome(String nome) {
        return null;
    }
}
