package org.example.Impl;

import org.example.SqlConnection;
import org.example.interfaces.AdminInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class AdminImpl implements AdminInterface {

    // this List should have Reservation id, Room id , User id , Check in date , Check out date and status
    @Override
    public void showRoomReservations() throws SQLException {
        String query = "SELECT * FROM reservation";
        SqlConnection sqlConnection = new SqlConnection();
        ResultSet results = SqlConnection.retrieveQueryResults(query);

        while (results.next()) {
            int reservId = results.getInt("reservation_id");
            int userId = results.getInt("user_id");
            int roomId = results.getInt("room_id");
            Date checkIn = results.getDate("check_in_date");
            Date checkOut = results.getDate("check_in_out");
            String status = results.getString("status");

            System.out.println("Reservation id: " + reservId
                    + ", Room id: " + roomId
                    + ", User id: " + userId
                    + ", Check-in Date: " + checkIn
                    + ", Check-out Date: " + checkOut
                    + ", Status: " + status);
        }
    }

    @Override
    public String acceptRoomReserve(int reserveId) {
        String newStatus = "ACCEPTED";
        String acceptReserve = String.format("UPDATE reservation SET status = '" + newStatus + "' "
                + "WHERE reservation_id = " + reserveId + ";");
        String result;
        SqlConnection conn = new SqlConnection();

        if (conn.executeQuery(acceptReserve)) {
            result = "Reservation successfully Accepted! ";
        } else {
            result = "Your Request Rejected";
        }
        return result;
    }

    @Override
    public String declienRoomReserve(int reserveId) {
        String newStatus = "DECLINED";
        String acceptReserve = String.format("UPDATE reservation SET status = '" + newStatus + "' "
                + "WHERE reservation_id = " + reserveId + ";");
        String result;

        SqlConnection conn = new SqlConnection();

        if (conn.executeQuery(acceptReserve)) {
            result = "Reservation successfully Declined! ";
        } else {
            result = "Your Request Rejected";
        }

        return result;
    }
}
