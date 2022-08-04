package com.wolfcode.spring3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class TestSpring3 {
    @Test
    public void test1(){
        ClassPathResource resource = new ClassPathResource("beans.xml");
        //XmlBeanFactory factory = new XmlBeanFactory(resource);
        AbstractApplicationContext factory  = new ClassPathXmlApplicationContext("beans.xml");
        MyJDBC jdbc = (MyJDBC)factory.getBean("jdbc");
        System.out.println(jdbc);
        //调用获取链接的方法
        jdbc.getConnetion();
        //关闭链接
        //jdbc.close();
        //手动注销容器的方法
        factory.registerShutdownHook();
    }
}
