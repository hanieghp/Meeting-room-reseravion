package org.example.Impl;

import org.example.entity.Room;
import org.example.interfaces.ManagerInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerImpl implements ManagerInterface {

    private static final String ROOMS_FILE_PATH = "rooms.csv";
    private List<Room> rooms = new ArrayList<>();
    private int userId;
    private String fullName;

    public ManagerImpl(int userId, String fullName) {
        this.userId = userId;
        this.fullName = fullName;
        loadRooms();
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Manager access is: ");
        while (true) {
            System.out.println("1. View all rooms");
            System.out.println("2. Add a room");
            System.out.println("3. Delete a room");
            System.out.println("4. Exit");
            System.out.println("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    getAllRooms();
                    break;
                case 2:
                    System.out.println("Enter the capacity of the room: ");
                    int capacity = scanner.nextInt();
                    addRoom(capacity);
                    break;
                case 3:
                    System.out.println("Enter the roomId you want to delete: ");
                    int delId = scanner.nextInt();
                    deleteRoom(delId);
                    break;
                case 4:
                    System.out.println("Exiting the system...");
                    saveRooms();
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    @Override
    public List<Room> getAllRooms() {
        for (Room room : rooms) {
            System.out.println("Room ID: " + room.getRoomId() + ", Capacity: " + room.getRoom_capacity() + ", isEmpty: " + room.getIsEmpty());
        }
        return rooms;
    }

    @Override
    public boolean addRoom(int roomCapacity) {
        int newRoomId = rooms.size() + 1;
        Room newRoom = new Room(roomCapacity, newRoomId);
        rooms.add(newRoom);
        saveRooms();
        System.out.println("Room added successfully.");
        return true;
    }

    @Override
    public boolean deleteRoom(int roomId) {
        Room roomToDelete = null;
        for (Room room : rooms) {
            if (room.getRoomId() == roomId) {
                roomToDelete = room;
                break;
            }
        }
        if (roomToDelete != null && roomToDelete.getIsEmpty() == 1) {
            rooms.remove(roomToDelete);
            saveRooms();
            System.out.println("Room deleted successfully.");
            return true;
        } else {
            System.out.println("Room is not empty or does not exist, cannot delete.");
            return false;
        }
    }

    private void saveRooms() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ROOMS_FILE_PATH))) {
            for (Room room : rooms) {
                writer.write(room.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving rooms: " + e.getMessage());
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
