package com.wolfcode.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class SpringTest {
    @Test
    public void test1(){
        //加载到beans.xml这个核心的spring文本容器中
        ClassPathResource resource = new ClassPathResource("beans.xml");
        //使用资源对象创建一个spring工厂
        XmlBeanFactory factory = new XmlBeanFactory(resource);
        //从工厂中获取容器中的Animal对象
        Object cat = factory.getBean("cat3");
        System.out.println(cat);
    }

}
