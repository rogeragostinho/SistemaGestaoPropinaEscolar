package com.rogerhugo.sistemagestaopropinaescolar.repository;

import com.rogerhugo.sistemagestaopropinaescolar.model.Curso;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CursoRepository extends AbstractRepository<Curso> {
    private static CursoRepository instance;

    private CursoRepository() {
        super("cursos", "nome, valorPropina");
    }

    public static CursoRepository getInstance() {
        if (instance == null) instance = new CursoRepository();
        return instance;
    }

    @Override
    protected void setCreateStatement(PreparedStatement ps, Curso curso) throws SQLException {
        ps.setString(1, curso.getNome());
        ps.setDouble(2, curso.getValorPropina());
    }

    @Override
    protected Curso mapResultSet(ResultSet rs) throws SQLException {
        return new Curso(rs.getInt("id") ,rs.getString("nome"), rs.getDouble("valorPropina"));
    }
}
