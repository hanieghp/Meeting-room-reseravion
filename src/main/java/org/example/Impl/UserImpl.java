package org.example.Impl;

import org.example.SqlConnection;
import org.example.entity.Room;
import org.example.entity.User;
import org.example.interfaces.UserInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserImpl implements UserInterface{
    private int userId;
    private String fullName;
    public UserImpl(int userId, String fullName) {
        this.userId = userId;
        this.fullName = fullName;
    }

    public void execute(){
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("1. View Available Rooms");
            System.out.println("2. Send Reservation Request");
            System.out.println("3. Check Reservation Status");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    List<Room> availableRooms = viewAvailableRooms();
                    if (availableRooms.isEmpty()) {
                        System.out.println("No available rooms at the moment.");
                    } else {
                        System.out.println("Available Rooms:");
                        for (Room room : availableRooms) {
                            System.out.println("Room ID: " + room.getRoomId() + ", Capacity: " + room.getRoom_capacity());
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter the room ID you want to reserve: ");
                    int roomId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter check-in date (YYYY-MM-DD): ");
                    String checkInDate = scanner.nextLine();
                    System.out.print("Enter check-out date (YYYY-MM-DD): ");
                    String checkOutDate = scanner.nextLine();

                    String reservationResult = sendReservationRequest(userId, roomId, checkInDate, checkOutDate);
                    System.out.println(reservationResult);
                    break;
                case 3:
                    System.out.print("Enter your room ID: ");
                    roomId = scanner.nextInt();

                    String status = checkReservationStatus(roomId, userId);
                    System.out.println("Reservation Status: " + status);
                    break;
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
    public List<Room> viewAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        String query = "SELECT room_id, room_capacity FROM rooms WHERE room_id NOT IN " +
                "(SELECT room_id FROM reservation WHERE status = 'PENDING' OR status = 'ACCEPTED')";
        try {
            SqlConnection connection = new SqlConnection();
            ResultSet rs = connection.retrieveQueryResults(query);
            while (rs.next()) {
                int roomId = rs.getInt("room_id");
                int roomCapacity = rs.getInt("room_capacity");
                availableRooms.add(new Room(roomCapacity, roomId));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(availableRooms.size());
        return availableRooms;
    }

    @Override
    public String sendReservationRequest(int userId, int roomId, String checkInDate, String checkOutDate) {
        String query = String.format(
                "INSERT INTO reservation (user_id, room_id, check_in_date, check_out_date, status) VALUES ('%s', '%s', '%s', '%s', 'PENDING')",
                userId, roomId, checkInDate, checkOutDate);
        try {
            SqlConnection connection = new SqlConnection();
            connection.executeQuery(query);
            ResultSet rs = connection.retrieveQueryResults("SELECT LAST_INSERT_ID() AS reservation_id");
            int id = 0;

            if (rs.next()) {
                id = rs.getInt("reservation_id");
                return "Reservation created successfully.";
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return "Failed to create reservation.";
    }

    @Override
    public String checkReservationStatus(int roomId, int userId) {
        String query = String.format(
                "SELECT status FROM reservation WHERE room_id = '%d' AND user_id = '%d'", roomId, userId);
        SqlConnection connection = new SqlConnection();
        ResultSet rs = connection.retrieveQueryResults(query);
        try {
            if (rs.next()) {
                return rs.getString("status");
            } else {
                return "Reservation not found.";
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return "Failed to retrieve reservation status.";
    }


}