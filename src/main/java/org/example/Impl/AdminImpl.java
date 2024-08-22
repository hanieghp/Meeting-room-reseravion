package org.example.Impl;

import org.example.SqlConnection;
import org.example.entity.Reservation;
import org.example.interfaces.AdminInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class AdminImpl implements AdminInterface {

    // this List should have Reservation id, Room id , User id , Check in date , Check out date and status
    @Override
    public List<Reservation> showRoomReservations() throws SQLException {
        String query = "SELECT * FROM reservation";
        SqlConnection sqlConnection = new SqlConnection();
        ResultSet results = sqlConnection.retrieveQueryResults(query);

        while (results.next()) {
            int reservId = results.getInt("reservation_id");
            int userId = results.getInt("user_id");
            int roomId = results.getInt("room_id");
            Date checkIn = results.getDate("check_in_date");
            Date checkOut = results.getDate("check_in_out");
            String status = results.getString("status");
        }

        return null;
    }

    @Override
    public String acceptRoomReserve() {
        return null;
    }

    @Override
    public String declienRoomReserve() {
        return null;
    }
}
