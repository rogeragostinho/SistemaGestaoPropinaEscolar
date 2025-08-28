package com.rogerhugo.sistemagestaopropinaescolar.repository;

import com.rogerhugo.sistemagestaopropinaescolar.db.ConnectionFactory;
import com.rogerhugo.sistemagestaopropinaescolar.model.Pagamento;
import com.rogerhugo.sistemagestaopropinaescolar.enums.MesDoAno;
import com.rogerhugo.sistemagestaopropinaescolar.utils.DateUtils;

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
        ps.setDate(1, DateUtils.localDateToSqlDate(pagamento.getData()));
        ps.setDouble(2, pagamento.getValor());
        ps.setInt(3, pagamento.getMesLetivo().getNumero());
        ps.setInt(4, pagamento.getAnoLetivo());
        ps.setInt(5, pagamento.getIdAluno());
    }

    @Override
    protected Pagamento mapResultSet(ResultSet rs) throws SQLException {
        return new Pagamento(rs.getInt("id"),
                rs.getInt("idAluno"),
                rs.getInt("anoLetivo"),
                MesDoAno.mesDoAnoByNumero(rs.getInt("mesLetivo")),
                rs.getDouble("valor"),
                rs.getDate("data").toLocalDate()
        );
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
