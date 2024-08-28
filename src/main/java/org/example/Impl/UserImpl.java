package org.example.Impl;

import org.example.entity.Room;
import org.example.entity.Reservation;
import org.example.interfaces.UserInterface;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserImpl implements UserInterface {
    private static final String ROOMS_FILE_PATH = "rooms.csv";
    private static final String RESERVATIONS_FILE_PATH = "reservations.csv";

    private int userId;
    private String fullName;

    private static List<Room> rooms = new ArrayList<>();
    private static List<Reservation> reservations = new ArrayList<>();

    public UserImpl(int userId, String fullName) {
        this.userId = userId;
        this.fullName = fullName;
        loadRooms();
        loadReservations();
    }

    public void execute() {
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
                    scanner.nextLine();
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
                    saveReservations();
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
        for (Room room : rooms) {
            boolean isReserved = false;
            for (Reservation reservation : reservations) {
                if (reservation.getRoomId() == room.getRoomId() &&
                        (reservation.getStatus().equals("PENDING") || reservation.getStatus().equals("ACCEPTED"))) {
                    isReserved = true;
                    break;
                }
            }
            if (!isReserved) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    @Override
    public String sendReservationRequest(int userId, int roomId, String checkInDate, String checkOutDate) {
        int reservationId = reservations.size() + 1;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date checkIn;
        Date checkOut;
        try {
            checkIn = sdf.parse(checkInDate);
            checkOut = sdf.parse(checkOutDate);
        } catch (ParseException e) {
            return "Invalid date format.";
        }

        Reservation reservation = new Reservation(reservationId, userId, roomId, checkIn, checkOut, "PENDING");
        reservations.add(reservation);
        saveReservations();
        return "Reservation created successfully.";
    }


    @Override
    public String checkReservationStatus(int roomId, int userId) {
        for (Reservation reservation : reservations) {
            if (reservation.getRoomId() == roomId && reservation.getUserId() == userId) {
                return reservation.getStatus();
            }
        }
        return "Reservation not found.";
    }

    private void saveReservations() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RESERVATIONS_FILE_PATH))) {
            for (Reservation reservation : reservations) {
                writer.write(reservation.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving reservations: " + e.getMessage());
        }
    }

    private void loadReservations() {
        File file = new File(RESERVATIONS_FILE_PATH);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    reservations.add(Reservation.fromCSV(line));
                }
            } catch (IOException e) {
                System.err.println("Error loading reservations: " + e.getMessage());
            }
        }
    }

    private void loadRooms() {
        File file = new File(ROOMS_FILE_PATH);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    rooms.add(Room.fromCSV(line));
                }
            } catch (IOException e) {
                System.err.println("Error loading rooms: " + e.getMessage());
            }
        }
    }
}
