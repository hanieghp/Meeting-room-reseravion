package org.example.entity;

public class Room {
    // Room id is an auto increment
    private int roomId;
    private int room_capacity;
    private int isEmpty = 1; // 1 is empty



    // Constructor
    public Room() {
        //
    }

    // setter and getter
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getRoom_capacity() {
        return room_capacity;
    }

    public void setRoom_capacity(int room_capacity) {
        this.room_capacity = room_capacity;
    }
    public int getIsEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(int isEmpty) {
        this.isEmpty = isEmpty;
    }
}
