package org.example.entity;

public class User {


    // Delete setter cus id is auto increment
    private int userId;

    private String password;

    private String fullName;

    private String role;

    public User( String password, String firstName, String lastName, String roll) {
        this.password = password;
        this.fullName = firstName;
        this.role = roll;
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
}
