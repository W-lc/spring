package com.wolfcode.spring7;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class MyDruid {
    private DruidDataSource druidDataSource;
    public MyDruid(){
        druidDataSource = new DruidDataSource();
        System.out.println("连接池已创建");
    }
    @PostConstruct
    //初始化连接池
    public void init(){
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/staffing_system");
        druidDataSource.setPassword("wlc011227");
        druidDataSource.setUsername("root");
        System.out.println("连接池已初始化");
    }
    //获取连接
    public Connection getConnection(){
        try {
            return druidDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @PreDestroy
    public void closeDruid(){
        druidDataSource.close();
        System.out.println("连接池已关闭");

    }
}
