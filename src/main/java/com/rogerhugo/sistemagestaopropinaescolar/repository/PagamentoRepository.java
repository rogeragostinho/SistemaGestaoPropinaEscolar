package com.rogerhugo.sistemagestaopropinaescolar.repository;

import com.rogerhugo.sistemagestaopropinaescolar.db.ConnectionFactory;
import com.rogerhugo.sistemagestaopropinaescolar.model.Pagamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PagamentoRepository extends AbstractRepository<Pagamento>{
    private static PagamentoRepository instance = new PagamentoRepository();

    protected PagamentoRepository() {
        super("pagamentos", "data, valor, mesLetivo, anoLetivo, idAluno");
    }

    public static PagamentoRepository getInstance() {
        return instance;
    }

    @Override
    protected void setCreateStatement(PreparedStatement ps, Pagamento pagamento) throws SQLException {
        ps.setInt(1, pagamento.getIdAluno());
        ps.setInt(2, pagamento.getAnoLetivo());
        ps.setInt(3, pagamento.getMesLetivo());
        ps.setDouble(4, pagamento.getValor());
        ps.setDate(5, (Date) pagamento.getData());
    }

    @Override
    protected Pagamento mapResultSet(ResultSet rs) throws SQLException {
        return new Pagamento(rs.getInt("idAluno"), rs.getInt("anoLetivo"), rs.getInt("mesLetivo"), rs.getDouble("valor"), rs.getDate("data"));
    }

    public List<Pagamento> findAllByIdAluno(int idAluno) {
        List<Pagamento> list = new ArrayList<>();

        String sql = String.format("SELECT * FROM %s WHERE idAluno = ?", table);

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);)
        {
            ps.setInt(1, idAluno);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
                list.add(mapResultSet(rs));;

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
