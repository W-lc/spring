package com.wolfcode.spring8.test;

import com.wolfcode.spring8.entity.User;
import com.wolfcode.spring8.service.UserService;
import com.wolfcode.test8.entity.Opration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyTestSpring8 {
    @Autowired
    UserService userService;
    @Test
    public void test1(){
        User user= new User();
        user.setDepart_id(1);
        user.setSex(1);
        user.setCreate_time("2022-09-03");
        user.setAccount(100.0);
        user.setPassword("123456");
        user.setAge(221);
        user.setId(27);
        user.setName("孤鹜");
        Opration opration = new Opration();
        opration.setOpration("插入用户信息");
        opration.setUid(28);
        userService.addUser(user,opration);
    }
}
