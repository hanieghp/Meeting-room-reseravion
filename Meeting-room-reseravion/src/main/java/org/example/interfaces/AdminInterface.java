package org.example.interfaces;

import org.example.entity.Reservation;

import java.sql.SQLException;
import java.util.List;

public interface AdminInterface {

    // define a method to show all Room Request
    void showRoomReservations() throws SQLException;

    // define a method to Accept Req for Room
    String acceptRoomReserve(int reserveId);

    // define a method to Decline Reservation

    String declienRoomReserve(int reserveId);
}
