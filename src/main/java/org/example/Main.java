package org.example;

import org.example.Impl.AdminImpl;
import org.example.Impl.ManagerImpl;
import org.example.Impl.UserImpl;
import org.example.entity.User;
import org.example.interfaces.UserInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserInterface user = null;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to login or signup? (login/signup)");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("signup")) {
            try {
                System.out.print("Enter password: ");
                String userPassword = scanner.nextLine();

                System.out.print("Enter first name: ");
                String firstName = scanner.nextLine();

                System.out.print("Enter last name: ");
                String lastName = scanner.nextLine();

                System.out.print("Enter role: ");
                String roll = scanner.nextLine();


                String sql = String.format("INSERT INTO users (password, first_name, last_name, roll) VALUES ('%s', '%s', '%s', '%s')",
                        userPassword,
                        firstName,
                        lastName,
                        roll);

                SqlConnection sqlConnection = new SqlConnection();
                // Return boolean result
                sqlConnection.executeQuery(sql);
                // Return Data as result
                ResultSet resultSetAOP = sqlConnection.retrieveQueryResults("SELECT LAST_INSERT_ID() AS user_id");

                if (resultSetAOP.next()) {
                    int userId = resultSetAOP.getInt("user_id");
//                    user = createUserObject(userId, userPassword, firstName, lastName, roll);
//                    System.out.println(user.toString());
                    System.out.println("User registered successfully!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (choice.equalsIgnoreCase("login")) {
            try {
                System.out.print("Enter first name: ");
                String firstName = scanner.nextLine();

                System.out.print("Enter last name: ");
                String lastName = scanner.nextLine();

                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/room_reserve", "root", "narges1382");
                Statement statement = connection.createStatement();
                String sql = String.format("SELECT * FROM users WHERE first_name = '%s' AND last_name = '%s' AND password = '%s'",
                        firstName, lastName, password);
                ResultSet resultSet = statement.executeQuery(sql);

                if (resultSet.next()) {
                    int userId = resultSet.getInt("user_id");
                    String userPassword = resultSet.getString("password");
                    String userFirstName = resultSet.getString("first_name");
                    String userLastName = resultSet.getString("last_name");
                    String userRoll = resultSet.getString("roll");
//                    user = createUserObject(userId, userPassword, userFirstName, userLastName, userRoll);
//                    System.out.println(user.getRoll());
                } else {
                    System.out.println("invalid");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid choice. Please select either 'login' or 'signup'.");
        }

        scanner.close();
    }


    // need change
//    private static UserInterface createUserObject(int userId, String password, String firstName, String lastName, String roll) {
//        switch (roll) {
//            case "ADMIN":
//                //****** need change
//                //return new AdminImpl(userId, password, firstName, lastName, roll);
//            case "MANAGER":
//                UserInterface baseUser = new UserImpl(password, firstName, lastName, roll);
//                return new ManagerImpl(baseUser);
//            case "USER":
//            default:
//                return new UserImpl( password, firstName, lastName, roll);
//        }
//    }
}

