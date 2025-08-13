package com.rogerhugo.sistemagestaopropinaescolar.repository;

import com.rogerhugo.sistemagestaopropinaescolar.db.ConnectionFactory;
import com.rogerhugo.sistemagestaopropinaescolar.model.Aluno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository extends AbstractRepository<Aluno> {
    private static AlunoRepository instance = new AlunoRepository();

    private AlunoRepository() {
        super("alunos", "nome, turma, classe, curso");
    }

    public static AlunoRepository getInstance() {
        return instance;
    }

    @Override
    public boolean create(Aluno aluno) {
        String sql = "INSERT INTO alunos (nome, turma, classe, curso) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);)
        {
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getTurma());
            ps.setString(3, aluno.getClasse());
            ps.setString(4, aluno.getCurso());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Aluno findById(int id) {
        String sql = "SELECT * FROM alunos WHERE id = " + id;

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);)
        {
            rs.next();
            return new Aluno(rs.getInt("id"), rs.getString("nome"), rs.getString("turma"), rs.getString("classe"), rs.getString("curso"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Aluno findByNome(String nome) {
        String sql = "SELECT * FROM alunos WHERE nome = " + nome;

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);)
        {
            rs.next();
            return new Aluno(rs.getInt("id"), rs.getString("nome"), rs.getString("turma"), rs.getString("classe"), rs.getString("curso"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Aluno> findAll() {
        List<Aluno> alunos = new ArrayList<>();

        String sql = "SELECT * FROM alunos";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);)
        {
            while (rs.next())
                alunos.add(new Aluno(rs.getInt("id"), rs.getString("nome"), rs.getString("turma"), rs.getString("classe"), rs.getString("curso")));

            return alunos;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean update(int id, Aluno aluno) {
        String sql = "UPDATE alunos SET nome = ?, turma = ?, classe = ?, curso = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);)
        {
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getTurma());
            ps.setString(3, aluno.getClasse());
            ps.setString(4, aluno.getCurso());
            ps.setInt(5, id);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM alunos WHERE id = " + id;

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();)
        {
            return stmt.executeUpdate(sql) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}