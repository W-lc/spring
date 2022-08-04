package com.wolfcode.JDBCTest;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class JDBCTest2 {
    /**
     * 测试 DruidDataSource连接池
     */
    @Test
    public void test_driuddataSource() throws SQLException {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        DruidDataSource druidDataSource = ac.getBean("druidDataSource", DruidDataSource.class);
        DruidPooledConnection connection = druidDataSource.getConnection();
        System.out.println(connection);


    }
}
