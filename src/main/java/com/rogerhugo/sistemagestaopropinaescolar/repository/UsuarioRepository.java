package com.rogerhugo.sistemagestaopropinaescolar.repository;

import com.rogerhugo.sistemagestaopropinaescolar.db.ConnectionFactory;
import com.rogerhugo.sistemagestaopropinaescolar.model.Aluno;
import com.rogerhugo.sistemagestaopropinaescolar.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository extends AbstractRepository<Usuario> {
    private UsuarioRepository() {
        super("usuarios", "tipo, nome, senha");
    }

    @Override
    public boolean create(Usuario usuario) {
        String sql = "INSERT INTO usuarios (tipo, nome, senha) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);)
        {
            ps.setString(1, usuario.getTipo());
            ps.setString(2, usuario.getNome());
            ps.setString(3, usuario.getSenha());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Usuario findById(int id) {
        String sql = String.format("SELECT * FROM %s WHERE id = %d", table, id);

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);)
        {
            rs.next();
            return new Usuario(rs.getInt("id"), rs.getString("tipo"), rs.getString("nome"), rs.getString("senha"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> lista = new ArrayList<>();

        String sql = String.format("SELECT * FROM %s", table);

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);)
        {
            while (rs.next())
                lista.add(new Usuario(rs.getInt("id"), rs.getString("tipo"), rs.getString("nome"), rs.getString("senha")));

            return lista;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean update(int id, Usuario usuario) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
