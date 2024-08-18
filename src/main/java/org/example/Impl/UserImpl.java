package org.example.Impl;

import org.example.entity.User;
import org.example.interfaces.UserInterface;

public class UserImpl extends User implements UserInterface{


    public UserImpl(int userId, String password, String firstName, String lastName, String roll) {
        super(userId, password, firstName, lastName, roll);
    }
}
