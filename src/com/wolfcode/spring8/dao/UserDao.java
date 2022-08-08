package com.wolfcode.spring8.dao;

import com.wolfcode.spring8.entity.Opration;
import com.wolfcode.spring8.entity.User;

/**
 * 用户相关持久层的接口
 */
public interface UserDao {
    /**
     * 定义一个方法插入用户
     * @param user
     */
    void insert(User user);

    /**
     * 插入日志信息
     * @param opration
     */
    void insertLog(Opration opration);
}
