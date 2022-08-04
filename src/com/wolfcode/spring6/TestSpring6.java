package com.wolfcode.spring6;

import com.wolfcode.spring5.Person3;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring6 {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Person3 p3 = ac.getBean("p3", Person3.class);
        System.out.println(p3.toString());
    }

    /**
     * 循环依赖-setter方式注入-测试
     */
    @Test
    public void test2(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        A a = ac.getBean("a", A.class);
        System.out.println(a);

    }
}
