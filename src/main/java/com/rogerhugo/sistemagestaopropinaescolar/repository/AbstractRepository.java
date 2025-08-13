package com.rogerhugo.sistemagestaopropinaescolar.repository;

import com.rogerhugo.sistemagestaopropinaescolar.db.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository<T> implements GenericRepository<T>{
    protected String table;
    protected String insertColumns;

    protected AbstractRepository(String table, String insertColumns) {
        this.table = table;
        this.insertColumns = insertColumns;
    }

    protected abstract void setCreateStatement(PreparedStatement ps, T t) throws SQLException;
    protected abstract T mapResultSet(ResultSet rs) throws SQLException;
    //protected abstract void setUpdateStatement(PreparedStatement ps, T t) throws SQLException;

    @Override
    public boolean create(T t) {
        String placeholder = insertColumns.replaceAll("[^,]+", "?");
        String sql = String.format("INSERT INTO %s (%s) VALUES (%s)", table, insertColumns, placeholder);

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);)
        {
            setCreateStatement(ps, t);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public T findById(int id) {
        String sql = String.format("SELECT * FROM %s WHERE id = ?", table);

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();)
        {
            ps.setInt(1, id);

            if (rs.next())
                return mapResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<T> findAll() {
        List<T> list = new ArrayList<>();

        String sql = String.format("SELECT * FROM %s", table);

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);)
        {
            while (rs.next())
                list.add(mapResultSet(rs));;

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean update(int id, T t) {
        String setPlaceholders = insertColumns.replaceAll("[^,]+", "$0 = ?");
        String sql = String.format("UPDATE %s SET %s WHERE id = ?", table, setPlaceholders);

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);)
        {
            setCreateStatement(ps, t);
            ps.setInt(insertColumns.split(",").length + 1, id);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql = String.format("DELETE FROM %s WHERE id = ?", table);

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);)
        {
            ps.setInt(1, id);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
