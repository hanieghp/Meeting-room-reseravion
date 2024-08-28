package org.example;

import org.example.Impl.AdminImpl;
import org.example.Impl.ManagerImpl;
import org.example.Impl.UserImpl;
import org.example.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Auth {
    private static final String FILE_PATH = "users.csv";
    private static List<User> users = new ArrayList<>();

    public Auth() {
        loadUsers();
    }

    public void signup(String fullName, String password, String role) {
        User user = new User(fullName, password, role);
        users.add(user);
        saveUsers();
        System.out.println("User registered successfully!");

        createUserObject(role, user.getUserId(), fullName);
    }

    public void login(String fullName, String password) {
        for (User user : users) {
            if (user.getFullName().equals(fullName) && user.getPassword().equals(password)) {
                System.out.println("Login successful!");
                createUserObject(user.getRole(), user.getUserId(), fullName);
                return;
            }
        }
        System.out.println("Invalid login credentials.");
    }

    private void createUserObject(String role, int userId, String fullName) {
        switch (role.toUpperCase()) {
            case "USER":
                UserImpl user = new UserImpl(userId, fullName);
                user.execute();
                break;
            case "MANAGER":
                ManagerImpl manager = new ManagerImpl(userId, fullName);
                manager.execute();
                break;
            case "ADMIN":
                AdminImpl admin = new AdminImpl();
                break;
            default:
                throw new IllegalArgumentException("Unknown role: " + role);
        }
    }

    private void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (User user : users) {
                writer.write(user.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving users: " + e.getMessage());
        }
    }

    private void loadUsers() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    users.add(User.fromCSV(line));
                }
            } catch (IOException e) {
                System.err.println("Error loading users: " + e.getMessage());
            }
        }
    }
}
