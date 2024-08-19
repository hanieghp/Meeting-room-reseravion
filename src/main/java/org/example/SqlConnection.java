package org.example;

import java.sql.*;
import java.util.List;
import java.util.Objects;

public class SqlConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/room_reserve";
    private static final String USER = "root";
    private static final String PASSWORD = "narges1382";


    // For boolean retrieval
    public Boolean executeQuery(String query) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            // Unsafe method for query in general
            return statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // For data retrieval
    public ResultSet retrieveQueryResults(String query) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            // Unsafe method for query in general
            return statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
