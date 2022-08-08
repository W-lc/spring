package com.wolfcode.spring8.util;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 事物管理器
 */
//@Component
public class MyTransManager {
    @Autowired
    DruidDataSource druidDataSource;
    //进行保存同一个操作
    private static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();
    //获取连接
    public Connection getConn(){
        Connection connection = threadLocal.get();
        if(connection!=null){
            return connection;
        }
        try {
            connection=druidDataSource.getConnection();
            threadLocal.set(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    //开启事物
    public void startTrans() throws SQLException {
        System.out.println("开启");
        getConn().setAutoCommit(false);
    }
    //提交
    public void commit() throws SQLException {
        System.out.println("提交");
        getConn().commit();
    }
    //回滚
    public void rollback() throws SQLException {
        getConn().rollback();
    }
}
