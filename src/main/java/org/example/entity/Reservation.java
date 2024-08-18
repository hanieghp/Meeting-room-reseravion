package org.example.entity;

import java.util.Date;

public class Reservation {
    private int reservationId;
    private int userId;
    private int roomId;
    private Date reservationDate;
    private String status;

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

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Reservation(int reservationId, int userId, int roomId, Date reservationDate, String status) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.roomId = roomId;
        this.reservationDate = reservationDate;
        this.status = status;
    }
}
