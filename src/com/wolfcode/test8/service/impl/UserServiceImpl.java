package com.wolfcode.test8.service.impl;

import com.wolfcode.test8.dao.UserDao;
import com.wolfcode.test8.entity.Opration;
import com.wolfcode.test8.entity.User;
import com.wolfcode.test8.service.UserService;
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
    /**
     * 以下表示业务方法中侵入事物管理相关代码
     * 该代码废除
     */
    //    @Autowired
//    MyTransManager myTransManager;

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

//    @Override
//    public void addUser(User user, Opration opration) {
//
//
//        try {
//            //开启事物
//            myTransManager.startTrans();
//            //调用dao层方法——插入对象
//            userDao.insert(user);
//            //调用dao层的方法————插入日志信息
//            userDao.insertLog(opration);
//            myTransManager.commit();
//        } catch (Exception e) {
//            try {
//                myTransManager.rollback();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//
//        }
//    }
}
