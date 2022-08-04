package com.wolfcode.test8.dao.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.wolfcode.test8.dao.UserDao;
import com.wolfcode.test8.entity.Opration;
import com.wolfcode.test8.entity.User;
import com.wolfcode.test8.util.MyTransManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@Repository
public class UserDaoImpl implements UserDao {
//    @Autowired
//    private DruidDataSource druidDataSource;

//    public DruidDataSource getDruidDataSource() {
//        return druidDataSource;
//    }

//    public void setDruidDataSource(DruidDataSource druidDataSource) {
//        this.druidDataSource = druidDataSource;
//    }
    @Autowired
    private MyTransManager myTransManager;
    @Override
    public void insert(User user) {
        try {
            Connection connection = myTransManager.getConn();
            PreparedStatement pst = connection.prepareStatement("insert into app01_userinfo values(?,?,?,?,?,?,?,?)");
            pst.setInt(1,user.getId());
            pst.setString(2,user.getName());
            pst.setString(3,user.getPassword());
            pst.setInt(4,user.getAge());
            pst.setDouble(5,user.getAccount());
            pst.setString(6,user.getCreate_time());
            pst.setInt(7,user.getSex());
            pst.setInt(8,user.getDepart_id());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertLog(Opration opration) {
        try {
            Connection connection = myTransManager.getConn();
            PreparedStatement pst = connection.prepareStatement("insert app01_test (opration,uid) values (?,?)");
            pst.setString(1,opration.getOpration());
            pst.setInt(2,opration.getUid());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
