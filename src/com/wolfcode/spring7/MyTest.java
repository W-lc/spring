package com.wolfcode.spring7;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class MyTest {
    @Test
    public void test1(){
        MyDruid myDruid = new MyDruid();
        //初始化操作
        myDruid.init();
        Connection connection = myDruid.getConnection();
        System.out.println(connection);
    }
}
