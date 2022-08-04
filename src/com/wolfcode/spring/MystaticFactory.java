package com.wolfcode.spring;
//静态工厂方式创建bean
public class MystaticFactory {
    public static Animal createAnimal(){
        return new Animal();
    }

}
