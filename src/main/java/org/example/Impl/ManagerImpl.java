package org.example.Impl;

import org.example.entity.Room;
import org.example.entity.User;
import org.example.interfaces.*;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ManagerImpl implements ManagerInterface, UserInterface {
    private final UserInterface user;

    public ManagerImpl(UserInterface user) {
        this.user = user;
    }

    @Override
    public List<Room> getAllRooms() {
        return List.of();
    }

    @Override
    public boolean addRoom(Room room) {
        String url = "jdbc:mysql://localhost:3306/room_reserve";
        String user = "root";
        String password = "narges1382";

        String sql = "INSERT INTO rooms (room_capacity, Check_In_Date, Check_Out_Date, isEmpty) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, room.getRoom_capacity());
            preparedStatement.setDate(2, java.sql.Date.valueOf(String.valueOf(room.getCheck_In_Date())));
            preparedStatement.setDate(3, java.sql.Date.valueOf(String.valueOf(room.getCheck_Out_Date())));
            preparedStatement.setBoolean(4, room.isEmpty());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; // Return true if at least one row was affected
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false in case of an error
        }
    }

    @Override
    public boolean deleteRoom(int roomId) {
        return false;
    }

    @Override
    public String getRoll() {
        return user.getRoll();
    }
}
