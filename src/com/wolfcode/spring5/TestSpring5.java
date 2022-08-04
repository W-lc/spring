package com.wolfcode.spring5;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring5 {
    /**
     * 测试传统方式如何使用setter赋值
     */
    @Test
    public void test1(){
        Person3 person = new Person3();
        person.setId(1);
        person.setName("zhangsan");
        System.out.println(person.toString());
    }
    @Test
    public void test2(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person3 p3 = classPathXmlApplicationContext.getBean("p3", Person3.class);
        System.out.println(p3.getId()+"----"+p3.getName());
    }

}
