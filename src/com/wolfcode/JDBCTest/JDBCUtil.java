package com.wolfcode.JDBCTest;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * 抽取工具类
 */
public class JDBCUtil {
    private static final String driverClassName;
    private static final String url;
    private static final String username;
    private static final String password;
    static {
        ResourceBundle jdbc = ResourceBundle.getBundle("jdbc");
        driverClassName=jdbc.getString("jdbc.driverClassName");
        url=jdbc.getString("jdbc.url");
        username=jdbc.getString("jdbc.username");
        password=jdbc.getString("jdbc.password");

    }

    /**
     *获取链接的方法
     */
    public static Connection getConnection(){
        //加载驱动
        try {
            Class.forName(driverClassName);
            try {
                 return DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭链接
     * @param rs
     * @param ps
     * @param conn
     */
    public static void close(ResultSet rs,Statement ps,Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

}
