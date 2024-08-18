package org.example.Impl;

import org.example.entity.User;
import org.example.interfaces.ManagerInterface;

public class ManagerImpl extends User implements ManagerInterface {

    public ManagerImpl(int userId, String password, String firstName, String lastName, String roll) {
        super(userId, password, firstName, lastName, roll);
    }
}
