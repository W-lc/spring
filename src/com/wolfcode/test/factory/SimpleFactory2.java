package com.wolfcode.test.factory;

public class SimpleFactory2 extends SimpleFactory{
    @Override
    public Pay createPay(String payType){
        return new HUAWEIPay();
    }
}
