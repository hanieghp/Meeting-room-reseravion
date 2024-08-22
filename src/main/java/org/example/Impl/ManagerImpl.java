package org.example.Impl;

import org.example.SqlConnection;
import org.example.entity.Room;
import org.example.interfaces.*;

import java.sql.*;
import java.util.List;

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

//        SqlConnection sqlConnection = new SqlConnection();
//        String sqlQuery = String.format("INSERT INTO rooms(room_capacity, Check_In_Date, Check_Out_Date, isEmpty) VALUES ('%s', '%s', '%s', '%s')",
//                room.getRoom_capacity(),
//                java.sql.Date.valueOf(String.valueOf(room.getCheck_In_Date())),
//                java.sql.Date.valueOf(String.valueOf(room.getCheck_Out_Date())),
//                room.isEmpty()
//        );
//        return sqlConnection.executeQuery(sqlQuery);
        return false;
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
