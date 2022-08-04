package com.wolfcode.spring7;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestSpring7 {
    @Autowired
    private Person person;
    @Test
    public void test1(){
        System.out.println(person);
    }
    @Autowired
    MyDruid myDruid;
    @Test
    public void test2(){
        Connection connection = myDruid.getConnection();
        System.out.println(connection);

    }
}
