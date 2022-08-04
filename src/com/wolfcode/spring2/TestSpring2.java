package com.wolfcode.spring2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;


public class TestSpring2 {
    @Test
    public void test1(){
        ClassPathResource resource = new ClassPathResource("beans.xml");
        XmlBeanFactory factory = new XmlBeanFactory(resource);
        Object p1 = factory.getBean("p1");
        System.out.println(p1);
        Object p2 = factory.getBean("p1");
        System.out.println(p2);
    }
}
