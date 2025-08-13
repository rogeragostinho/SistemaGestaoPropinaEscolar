package com.rogerhugo.sistemagestaopropinaescolar.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractRepository<T> implements GenericRepository<T>{
    private final String URL = "jdbc:mysql://localhost:3306/sistema_gestao_propina_escolar";
    private final String USER = "root";
    private final String PASSWORD = "";

    protected String table;
    protected String campos;

    public AbstractRepository(String table, String campos) {
        this.table = table;
        this.campos = campos;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
