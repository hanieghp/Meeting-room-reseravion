package org.example.entity;

import java.util.Date;

public class Reservation {
    // reservationId is Auto increment
    private int reservationId;
    private int userId;
    private int roomId;

    private Date checkInDate;
    private Date checkOutDate;
    private String status;

    public int getReservationId() {
        return reservationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

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

    public Reservation(int userId, int roomId, Date checkInDate, Date checkOutDate, String status) {
        this.userId = userId;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
    }
}