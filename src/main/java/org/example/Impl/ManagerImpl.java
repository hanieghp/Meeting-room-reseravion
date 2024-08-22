package org.example.Impl;

import org.example.SqlConnection;
import org.example.entity.Reservation;
import org.example.entity.Room;
import org.example.interfaces.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerImpl implements ManagerInterface {

    private final SqlConnection sqlConnection;
    private int userId;
    private String fullName;

    public ManagerImpl(int userId, String fullName) {
        this.userId = userId;
        this.fullName = fullName;
        this.sqlConnection = new SqlConnection();
    }

    public void execute(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Manager access is: ");
        while (true){
            System.out.println("1. view all rooms");
            System.out.println("2. add a room");
            System.out.println("3. delete a room");
            System.out.println("4. Exit");
            System.out.println("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    getAllRooms();
                    break;
                case 2:
                    System.out.println("Enter the capacity of room: ");
                    int capacity = scanner.nextInt();
                    addRoom(String.valueOf(capacity));
                    break;
                case 3:
                    System.out.println("Enter the roomId you want to delete: ");
                    int delId = scanner.nextInt();
                    deleteRoom(delId);
                case 4:
                    System.out.println("Exiting the system...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
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

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 9b58d2978f7f1c705380cfa5fc4db90bf2937a5b
        System.out.println("Executing query: " + query);
        boolean isSuccess = sqlConnection.executeQuery(query);

        return !isSuccess;
<<<<<<< HEAD
=======
//        SqlConnection sqlConnection = new SqlConnection();
//        String sqlQuery = String.format("INSERT INTO rooms(room_capacity, Check_In_Date, Check_Out_Date, isEmpty) VALUES ('%s', '%s', '%s', '%s')",
//                room.getRoom_capacity(),
//                java.sql.Date.valueOf(String.valueOf(room.getCheck_In_Date())),
//                java.sql.Date.valueOf(String.valueOf(room.getCheck_Out_Date())),
//                room.isEmpty()
//        );
//        return sqlConnection.executeQuery(sqlQuery);
        return false;
>>>>>>> Admin
=======
>>>>>>> 9b58d2978f7f1c705380cfa5fc4db90bf2937a5b
    }


    @Override
    public boolean deleteRoom(int roomId) {
        String checkQuery = String.format("SELECT isEmpty FROM rooms WHERE room_id = %d", roomId);
        ResultSet rs = sqlConnection.retrieveQueryResults(checkQuery);

        try {
            if (rs.next()) {
                int isEmpty = rs.getInt("isEmpty");
                if (isEmpty == 1) {
                    String deleteQuery = String.format("DELETE FROM rooms WHERE room_id = %d", roomId);
                    sqlConnection.executeQuery(deleteQuery);

                    System.out.println("Room deleted successfully.");
                } else {
                    System.out.println("Room is not empty, cannot delete.");
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
