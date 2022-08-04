package com.wolfcode.test8.service;

import com.wolfcode.test8.entity.Opration;
import com.wolfcode.test8.entity.User;

import java.sql.SQLException;

public interface UserService {
    void addUser(User user, Opration opration);
}
