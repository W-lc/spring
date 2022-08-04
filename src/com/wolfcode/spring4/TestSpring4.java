package com.wolfcode.spring4;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring4 {
    /**
     * 测试懒加载
     * false default 即刻加载创建对象
     * true 懒加载
     */
    @Test
   public void test1(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        //Object p2 = applicationContext.getBean("p2");
        //System.out.println(p2);
    }

}
