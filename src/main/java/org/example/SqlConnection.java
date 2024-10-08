package org.example;


import java.sql.*;

import java.util.List;
import java.util.Objects;
import java.sql.Connection; import java.sql.DriverManager; import java.sql.SQLException; import java.util.Properties;



public class SqlConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/room_reserve";
    private static final String USER = "root";
    private static final String PASSWORD = "root";


    // For boolean retrieval
    public static Boolean executeQuery(String query) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            // Unsafe method for query in general
            return statement.execute(query);
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            return false;
        }
    }

    // For data retrieval
    public static ResultSet retrieveQueryResults(String query) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            // Unsafe method for query in general
            return statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
