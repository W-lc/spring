package com.wolfcode.mybatis_test.test;

import com.wolfcode.mybatis_test.dao.UserDao;
import com.wolfcode.mybatis_test.dao.impl.UserDaoImpl;
import com.wolfcode.mybatis_test.entity.T_user;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MyTest {
    /**
     * 多条数据集合查询
     */
    @Test
    public void test5_UserDao_selectUserList(){
        UserDao userDao = new UserDaoImpl();
        Map<String,Object> paramMap=new HashMap<String,Object>();
        paramMap.put("depart_id",2);
        paramMap.put("password","123");
        List<T_user> select = userDao.select(paramMap);
        for (T_user user:select){
            System.out.println(user);
        }
    }
    /**
     * 测试单条查询
     */
    @Test
    public void test4_UserDao_selectSingle(){
        UserDao userDao = new UserDaoImpl();
        T_user user = userDao.selectSingle(1);
        System.out.println(user);
    }
    /**
     * 测试UserDao删除
     */
    @Test
    public void test3_UserDao_delete(){
        UserDao userDao = new UserDaoImpl();
        userDao.delete(29);
    }
    /**
     * 测试UserDao更新
     */
    @Test
    public void test2_UserDao_update(){
        UserDao userDao = new UserDaoImpl();
        T_user user=new T_user();
        user.setSex(1);
        user.setId(30);
        userDao.update(user);
    }
    @Test
    /**
     * 测试UserDao插入
     */
    public void test1_UserDao_insert(){
        UserDao userDao = new UserDaoImpl();
        //创建用户信息
        T_user user = new T_user();
        user.setName("宏宇");
        user.setPassword("12343");
        user.setAge(20);
        user.setDepart_id(1);
        user.setAccount(500.0);
        user.setCreate_time("2023-09-12");
        user.setSex(2);
        userDao.insert(user);
    }
}
