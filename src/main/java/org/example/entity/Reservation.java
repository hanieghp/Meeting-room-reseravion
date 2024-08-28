package org.example.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
    private int reservationId;
    private int userId;
    private int roomId;
    private Date checkInDate;
    private Date checkOutDate;
    private String status;

    public Reservation(int reservationId, int userId, int roomId, Date checkInDate, Date checkOutDate, String status) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
    }

    // Getters and Setters


    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String toCSV() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return reservationId + "," + userId + "," + roomId + "," +
                sdf.format(checkInDate) + "," + sdf.format(checkOutDate) + "," + status;
    }

    public static Reservation fromCSV(String csv) {
        try {
            String[] parts = csv.split(",");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            int reservationId = Integer.parseInt(parts[0]);
            int userId = Integer.parseInt(parts[1]);
            int roomId = Integer.parseInt(parts[2]);
            Date checkInDate = sdf.parse(parts[3]);
            Date checkOutDate = sdf.parse(parts[4]);
            String status = parts[5];
            return new Reservation(reservationId, userId, roomId, checkInDate, checkOutDate, status);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing reservation CSV", e);
        }
    }

}
