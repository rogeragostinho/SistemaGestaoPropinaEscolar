package com.rogerhugo.sistemagestaopropinaescolar.repository;

import com.rogerhugo.sistemagestaopropinaescolar.db.ConnectionFactory;
import com.rogerhugo.sistemagestaopropinaescolar.model.Aluno;

import java.sql.*;

public class AlunoRepository extends AbstractRepository<Aluno> {
    private static AlunoRepository instance = new AlunoRepository();

    private AlunoRepository() {
        super("alunos", "nome, classe, idCurso, turma");
    }

    public static AlunoRepository getInstance() {
        return instance;
    }

    @Override
    protected void setCreateStatement(PreparedStatement ps, Aluno aluno) throws SQLException {
        ps.setString(1, aluno.getNome());
        ps.setString(2, aluno.getClasse());
        ps.setInt(3, aluno.getIdCurso());
        ps.setString(4, aluno.getTurma());
    }

    @Override
    protected Aluno mapResultSet(ResultSet rs) throws SQLException {
        return new Aluno(rs.getInt("id"), rs.getString("nome"), rs.getString("classe"), rs.getInt("idCurso"), rs.getString("turma"));
    }
}