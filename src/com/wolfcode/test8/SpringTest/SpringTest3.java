package com.wolfcode.test8.SpringTest;

import com.wolfcode.test8.entity.Opration;
import com.wolfcode.test8.entity.User;
import com.wolfcode.test8.service.UserService;
import com.wolfcode.test8.service.impl.TransInvocationHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Proxy;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")

public class SpringTest3 {
    @Autowired
    TransInvocationHandler transInvocationHandler;
    /**
     * 测试jdk动态代理
     */
    @Test
    public void test1(){
        //生成代理类对象
        //生成代理类
        //使用反射机制
        //第一个参数表示真实业务对象对应的加载器
        //第二个参数表示真实业务对象的真实业务类实现的接口
        //第三个参数表示模版-就是告诉jdk-需要生成的代理类是要干嘛的
        UserService userService = (UserService)Proxy.newProxyInstance(transInvocationHandler.getTarget().getClass().getClassLoader(),
                transInvocationHandler.getTarget().getClass().getInterfaces(),transInvocationHandler);
        User user = new User();
        user.setDepart_id(1);
        user.setSex(1);
        user.setCreate_time("2022-09-03");
        user.setAccount(100.0);
        user.setPassword("123456");
        user.setAge(21);
        user.setId(19);
        user.setName("李佳奇");
        Opration opration = new Opration();
        opration.setOpration("插入用户信息");
        opration.setUid(19);
        userService.addUser(user,opration);
    }
}
