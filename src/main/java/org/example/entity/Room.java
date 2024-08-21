package org.example.entity;

public class Room {
    // Room id is an auto increment
    private int roomId;
    private int room_capacity;

    // Constructor
    public Room(int room_capacity, int roomId) {
        this.room_capacity = room_capacity;
        this.roomId = roomId;
    }

    // setter and getter
    public int getRoomId() {
        return roomId;
    }

    public void setRoom_capacity(int room_capacity) {
        this.room_capacity = room_capacity;
    }

    public int getRoom_capacity() {
        return room_capacity;
    }

}
