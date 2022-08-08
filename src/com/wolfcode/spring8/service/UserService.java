package com.wolfcode.spring8.service;

import com.wolfcode.spring8.entity.Opration;
import com.wolfcode.spring8.entity.User;

public interface UserService {
    void addUser(User user, Opration opration);
}
