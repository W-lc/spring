package com.wolfcode.test8.SpringTest;

import com.wolfcode.test8.entity.Opration;
import com.wolfcode.test8.entity.User;
import com.wolfcode.test8.service.UserService;
import com.wolfcode.test8.service.impl.TransInvocationHandler;
import com.wolfcode.test8.service.impl.TransInvocationHandler_cglib;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Proxy;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")

public class SpringTest3 {
    @Autowired
    TransInvocationHandler transInvocationHandler;
    @Autowired
    TransInvocationHandler_cglib transInvocationHandler_cglib;

    /**
     * 测试使用cglib动态使用
     */
    @Test
    public void test2(){
        //spring框架提供了一个Enhancer类型
        Enhancer enhancer = new Enhancer();
        //使用该对象设置相关的对象
        //设置生成的代理类继承的类--设置业务类-类型
        enhancer.setSuperclass(transInvocationHandler_cglib.getTarget().getClass());
        //设置代理类需要做什么事情（体现在TransInvocationHandler_cglib）
        enhancer.setCallback(transInvocationHandler_cglib);
        //根据当前的设置代理类（代理类对象）
        UserService userService = (UserService)enhancer.create();
        //调用userService中的方法
        User user = new User();
        user.setDepart_id(1);
        user.setSex(1);
        user.setCreate_time("2022-09-03");
        user.setAccount(100.0);
        user.setPassword("123456");
        user.setAge(21);
        user.setId(21);
        user.setName("蹇帅");
        Opration opration = new Opration();
        opration.setOpration("插入用户信息");
        opration.setUid(21);
        userService.addUser(user,opration);

    }
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
