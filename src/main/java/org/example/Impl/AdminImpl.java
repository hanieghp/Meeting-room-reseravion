package org.example.Impl;

import org.example.entity.User;
import org.example.interfaces.AdminInterface;

public class AdminImpl extends User implements AdminInterface {

    public AdminImpl(int userId, String password, String firstName, String lastName, String roll) {
        super(userId, password, firstName, lastName, roll);
    }
}
