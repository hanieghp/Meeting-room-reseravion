package org.example.Impl;

import org.example.entity.Room;
import org.example.entity.User;
import org.example.interfaces.*;
import java.util.List;

public class ManagerImpl implements ManagerInterface, UserInterface {
    private final UserInterface user;

    public ManagerImpl(UserInterface user) {
        this.user = user;
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

    @Override
    public String getRoll() {
        return user.getRoll();
    }
}
