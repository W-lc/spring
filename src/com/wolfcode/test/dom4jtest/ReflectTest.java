package com.wolfcode.test.dom4jtest;

import org.junit.Test;

import java.lang.reflect.Field;

public class ReflectTest {
    @Test
    public void test1() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //首先加载到该类型
        Class<?> aClass = Class.forName("com.wolfcode.test.dom4jtest.Student");
        //通过反射的方式创建对象
        Object o= aClass.newInstance();
        //打印对象
        System.out.println(o);
        Field[]  declaredFields= aClass.getDeclaredFields();
        for(Field f:declaredFields){
            System.out.println(f.getName());
        }
    }
}
