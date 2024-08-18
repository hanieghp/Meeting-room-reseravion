package org.example.entity;

import java.util.Date;

public class Room {
    private int roomId;
    private int room_capacity;
    private Date Check_In_Date;
    private Date Check_Out_Date;
    private boolean isEmpty;

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoom_capacity(int room_capacity) {
        this.room_capacity = room_capacity;
    }

    public int getRoom_capacity() {
        return room_capacity;
    }

    public void setCheck_In_Date(Date check_In_Date) {
        Check_In_Date = check_In_Date;
    }

    public Date getCheck_In_Date() {
        return Check_In_Date;
    }

    public void setCheck_Out_Date(Date check_Out_Date) {
        Check_Out_Date = check_Out_Date;
    }

    public Date getCheck_Out_Date() {
        return Check_Out_Date;
    }
}
