package org.example.entity;

public class User {

    private int userId;

    private int roomId;

    private String password;

    private String firstName;

    private String lastName;

    private String roll;

    public User(int userId, int roomId, String password, String firstName, String lastName, String roll) {
        this.userId = userId;
        this.roomId = roomId;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roll = roll;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }
}
