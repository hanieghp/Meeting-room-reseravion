package org.example.entity;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private static int userIdCounter = 1;
    private int userId;
    private String password;
    private String fullName;
    private String role;

    public User(String fullName, String password, String role) {
        this.userId = userIdCounter++;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String toCSV() {
        return userId + "," + fullName + "," + password + "," + role;
    }

    public static User fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Invalid CSV line: " + csvLine);
        }
        User user = new User(parts[1], parts[2], parts[3]);
        user.userId = Integer.parseInt(parts[0]);
        return user;
    }
}
