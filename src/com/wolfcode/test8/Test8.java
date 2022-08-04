package com.wolfcode.test8;

import com.wolfcode.test8.dao.impl.UserDaoImpl;
import com.wolfcode.test8.entity.User;
import com.wolfcode.test8.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test8 {
    @Test
    public void test2_userService(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = ac.getBean("userService", UserService.class);
        
    }
    @Test
    public void test1_UserDao(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        UserDaoImpl userDao = ac.getBean("userDao", UserDaoImpl.class);
        User user = new User();
        user.setDepart_id(1);
        user.setSex(1);
        user.setCreate_time("2022-09-13");
        user.setAccount(800.0);
        user.setId(7);
        user.setPassword("123456");
        user.setAge(20);
        user.setName("张力文");
        System.out.println(user);
        userDao.insert(user);
    }
}
