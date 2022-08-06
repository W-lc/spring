package com.wolfcode.test8.service.impl;

import com.wolfcode.test8.entity.Opration;
import com.wolfcode.test8.entity.User;
import com.wolfcode.test8.service.UserService;
import com.wolfcode.test8.util.MyTransManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
@Service
public class UserServiceImplProxy implements UserService {
    @Autowired
    private UserService userService;
    @Autowired
    private MyTransManager myTransManager;
    @Override
    public void addUser(User user, Opration opration) {
        System.out.println("执行代理类中的方法");
        try {
            myTransManager.startTrans();
            userService.addUser(user,opration);
            myTransManager.commit();
        } catch (SQLException e) {
            try {
                myTransManager.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

    }
}
