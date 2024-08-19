package org.example.Impl;

import org.example.entity.Room;
import org.example.entity.User;
import org.example.interfaces.ManagerInterface;

import java.util.List;

public class ManagerImpl extends User implements ManagerInterface {

    public ManagerImpl(int userId, String password, String firstName, String lastName, String roll) {
        super(userId, password, firstName, lastName, roll);
    }

    @Override
    public List<Room> getAllRooms() {
        return List.of();
    }

    @Override
    public boolean addRoom(Room room) {
        return false;
    }

    @Override
    public boolean deleteRoom(int roomId) {
        return false;
    }
}
