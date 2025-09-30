package com.agenda.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:sqlserver://localhost;databaseName=AgendaDB;integratedSecurity=true;encrypt=false";
    ;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            System.out.println("Conexión exitosa");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
