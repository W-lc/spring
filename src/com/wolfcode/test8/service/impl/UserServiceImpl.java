package com.wolfcode.test8.service.impl;

import com.wolfcode.test8.dao.UserDao;
import com.wolfcode.test8.entity.Opration;
import com.wolfcode.test8.entity.User;
import com.wolfcode.test8.service.UserService;
import com.wolfcode.test8.util.MyTransManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    MyTransManager myTransManager;

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void addUser(User user, Opration opration) {


        try {
            //开启事物
            myTransManager.startTrans();
            //调用dao层方法——插入对象
            userDao.insert(user);
            //调用dao层的方法————插入日志信息
            userDao.insertLog(opration);
            myTransManager.commit();
        } catch (Exception e) {
            try {
                myTransManager.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }
}
