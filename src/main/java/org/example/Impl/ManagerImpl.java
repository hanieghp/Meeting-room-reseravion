package org.example.Impl;

import org.example.SqlConnection;
import org.example.entity.Reservation;
import org.example.entity.Room;
import org.example.interfaces.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerImpl implements ManagerInterface {

    private final SqlConnection sqlConnection;
//    private final UserInterface user;

    public ManagerImpl() {
        this.sqlConnection = new SqlConnection();
        //this.user = user;
    }

    @Override
    public List<Room> getAllRooms() {
        String query = "SELECT * FROM rooms";
        ResultSet rs = SqlConnection.retrieveQueryResults(query);

        List<Room> rooms = new ArrayList<>();
        try {
            while (rs.next()) {
                Room room = new Room();
                room.setRoomId(rs.getInt("room_id"));
                room.setRoom_capacity(Integer.parseInt(rs.getString("room_capacity")));
                room.setIsEmpty(rs.getInt("isEmpty"));
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Room room : rooms) {
            System.out.println("Room ID: " + room.getRoomId() + ", Capacity: " + room.getRoom_capacity() + ", isEmpty: " + room.getIsEmpty());
        }

        return rooms;
    }

    @Override
    public boolean addRoom(String roomCapacity) {
        String query = String.format("INSERT INTO rooms (room_capacity) VALUES ('%s')", roomCapacity);

        System.out.println("Executing query: " + query);
        boolean isSuccess = sqlConnection.executeQuery(query);

        return !isSuccess;
    }


    @Override
    public boolean deleteRoom(int roomId) {
        // check if the room is empty or not
        return true;
    }



}
