package com.wolfcode.spring8.service.impl;

import com.wolfcode.spring8.dao.UserDao;
import com.wolfcode.spring8.entity.Opration;
import com.wolfcode.spring8.entity.User;
import com.wolfcode.spring8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user, Opration opration) {
        //调用dao层方法——插入对象
        userDao.insert(user);
        //调用dao层的方法————插入日志信息
        userDao.insertLog(opration);
    }
}
