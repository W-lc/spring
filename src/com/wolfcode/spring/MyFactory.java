package com.wolfcode.spring;


import org.springframework.beans.factory.FactoryBean;

public class MyFactory implements FactoryBean<Animal> {

    @Override
    public Animal getObject() throws Exception {
        return new Animal(12,"cat");
    }
    //判断类型的方法-提供给spring容器使用
    @Override
    public Class<?> getObjectType() {
        return Animal.class;
    }
}
