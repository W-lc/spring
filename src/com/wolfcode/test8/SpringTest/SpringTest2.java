package com.wolfcode.test8.SpringTest;

import com.wolfcode.test8.entity.Opration;
import com.wolfcode.test8.entity.User;
import com.wolfcode.test8.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class SpringTest2 {
    @Autowired
    UserService userServiceImplProxy;
    /**
     * 测试静态代理方式
     * 实现业务功能事物管理功能增强
     */
    @Test
    public void test1(){
        User user = new User();
        user.setDepart_id(1);
        user.setSex(1);
        user.setCreate_time("2022-09-03");
        user.setAccount(100.0);
        user.setPassword("123456");
        user.setAge(21);
        user.setId(18);
        user.setName("王利聪");
        Opration opration = new Opration();
        opration.setOpration("插入用户信息");
        opration.setUid(17);
        userServiceImplProxy.addUser(user,opration);
    }
}
