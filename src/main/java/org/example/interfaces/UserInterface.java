package org.example.interfaces;

import org.example.entity.Room;

import java.util.List;

public interface UserInterface {
    // show Room List
    List<Room> viewAvailableRooms();
    // Req for Room
    String sendReservationRequest(int userId, int roomId, String checkInDate, String checkOutDate);
    // Show Req Status (Accepted, Declined , Waiting for Manager)
    String checkReservationStatus(int roomId, int userId);
    // User sign up

}
