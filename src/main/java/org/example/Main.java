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
        Scanner scanner = new Scanner(System.in);
        Auth auth = new Auth();

        System.out.println("Do you want to login or signup? (login/signup)");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("signup")) {
            System.out.print("Enter full name: ");
            String fullName = scanner.nextLine();

            System.out.print("Enter password: ");
            String userPassword = scanner.nextLine();

            System.out.print("Enter role: ");
            String role = scanner.nextLine();

            auth.signup(fullName, userPassword, role);

        } else if (choice.equalsIgnoreCase("login")) {
            try {
                System.out.print("Enter full name: ");
                String fullName = scanner.nextLine();

                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                auth.login(fullName, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid choice. Please select either 'login' or 'signup'.");
        }

        scanner.close();
    }
}