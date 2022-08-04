package com.wolfcode.test.factory;

import org.junit.jupiter.api.Test;

public class MyTest {
    @Test
    public void test1(){
        MyService myService = new MyService();
        myService.usePay("alipay");
    }
    @Test
    public void test2(){
        MyService2 myService2 = new MyService2();
        myService2.setSimpleFactory(new SimpleFactory());
        myService2.usepay("alipay");
    }
    @Test
    public void test3(){
        MyService2 myService2 = new MyService2();
        myService2.setSimpleFactory(new SimpleFactory2());
        myService2.usepay("alipay");
    }
}
