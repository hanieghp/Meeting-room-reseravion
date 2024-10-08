package org.example.entity;

public class Room {
    private int roomId;
    private int room_capacity;
    private int isEmpty = 1; // 1 is empty

    public Room(int room_capacity, int roomId) {
        this.room_capacity = room_capacity;
        this.roomId = roomId;
    }

    public Room() {
    }

    // Getter and Setter methods

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

    public String toCSV() {
        return roomId + "," + room_capacity + "," + isEmpty;
    }

    public static Room fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid CSV line: " + csvLine);
        }
        Room room = new Room();
        room.roomId = Integer.parseInt(parts[0]);
        room.room_capacity = Integer.parseInt(parts[1]);
        room.isEmpty = Integer.parseInt(parts[2]);
        return room;
    }
}
