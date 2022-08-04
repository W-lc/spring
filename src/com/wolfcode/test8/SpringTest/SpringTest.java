package com.wolfcode.test8.SpringTest;


import com.wolfcode.test8.dao.UserDao;
import com.wolfcode.test8.entity.Opration;
import com.wolfcode.test8.entity.User;
import com.wolfcode.test8.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class SpringTest {
    @Autowired
    private UserService userService;
    @Autowired
    UserDao userDao;
    @Test
    public void test2(){
        Opration opration = new Opration();
        opration.setOpration("测试");
        opration.setUid(1);
        userDao.insertLog(opration);
    }
    @Test
    public void test3() {
        System.out.println(userService);
        User user = new User();
        user.setDepart_id(1);
        user.setSex(1);
        user.setCreate_time("20220903");
        user.setAccount(100.0);
        user.setPassword("123456");
        user.setAge(21);
        user.setId(16);
        user.setName("王伟");
        Opration opration = new Opration();
        opration.setOpration("插入用户信息");
        opration.setUid(16);
        userService.addUser(user,opration);
    }
    @Test
    public void test1(){
        System.out.println(userService);
        User user = new User();
        user.setDepart_id(1);
        user.setSex(1);

        user.setCreate_time("2022-09-03");
        user.setAccount(100.0);
        user.setId(11);
        user.setPassword("123456");
        user.setAge(21);
        user.setName("何宝林");
//        userService.addUser(user);
    }
}
