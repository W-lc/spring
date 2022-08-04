package com.wolfcode.test8.service.impl;

import com.wolfcode.test8.dao.UserDao;
import com.wolfcode.test8.entity.User;
import com.wolfcode.test8.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {
        userDao.insert(user);
    }
}
