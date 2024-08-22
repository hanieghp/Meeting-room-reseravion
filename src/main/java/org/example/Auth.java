package org.example;


import java.sql.ResultSet;
import java.sql.SQLException;

public class Auth {
    public int signup(String fullName, String password, String role){
        String sql = String.format("INSERT INTO users (password, full_name, role) VALUES ('%s', '%s', '%s')",
                password,
                fullName,
                role);
        SqlConnection sqlConnection = new SqlConnection();
        sqlConnection.executeQuery(sql);
        // Return Data as result
        ResultSet resultSetAOP = sqlConnection.retrieveQueryResults("SELECT LAST_INSERT_ID() AS user_id");
        int userId = 0;
        try {
            if (resultSetAOP.next()) {
                userId = resultSetAOP.getInt("user_id");
                System.out.println("User registered successfully!");
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return userId;
    }
    public int login(String fullName, String password){
        String sql = String.format("SELECT * FROM users WHERE full_name = '%s' AND password = '%s'",
                fullName, password);
        SqlConnection sqlConnection = new SqlConnection();
        // Return Data as result
        ResultSet resultSetAOP = sqlConnection.retrieveQueryResults(sql);
        int userId = 0;
        try{
            if (resultSetAOP.next()) {
                userId = resultSetAOP.getInt("user_id");
            } else {
                System.out.println("invalid");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return userId;
    }
}
