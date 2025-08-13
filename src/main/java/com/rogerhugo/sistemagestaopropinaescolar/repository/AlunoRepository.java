package com.rogerhugo.sistemagestaopropinaescolar.repository;

import com.rogerhugo.sistemagestaopropinaescolar.db.ConnectionFactory;
import com.rogerhugo.sistemagestaopropinaescolar.model.Aluno;

import java.sql.*;

public class AlunoRepository extends AbstractRepository<Aluno> {
    private static AlunoRepository instance = new AlunoRepository();

    private AlunoRepository() {
        super("alunos", "nome, turma, classe, curso");
    }

    public static AlunoRepository getInstance() {
        return instance;
    }

    @Override
    protected void setCreateStatement(PreparedStatement ps, Aluno aluno) throws SQLException {
        ps.setString(1, aluno.getNome());
        ps.setString(2, aluno.getTurma());
        ps.setString(3, aluno.getClasse());
        ps.setString(4, aluno.getCurso());
    }

    @Override
    protected Aluno mapResultSet(ResultSet rs) throws SQLException {
        return new Aluno(rs.getInt("id"), rs.getString("nome"), rs.getString("turma"), rs.getString("classe"), rs.getString("curso"));
    }
}