package com.wolfcode.test8.dao;

import com.wolfcode.test8.entity.User;

import java.sql.SQLException;

/**
 * 用户相关持久层的接口
 */
public interface UserDao {
    /**
     * 定义一个方法插入用户
     * @param user
     */
    void insert(User user);
}
