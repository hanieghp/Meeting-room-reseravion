package org.example.interfaces;

import org.example.entity.Room;
import java.util.List;

public interface ManagerInterface {

    // Method to retrieve list of all rooms (both occupied and empty)
    List<Room> getAllRooms();

    // Method to add a new room to the database
    boolean addRoom(Room room);

    // Method to delete a room from the database
    boolean deleteRoom(int roomId);
}