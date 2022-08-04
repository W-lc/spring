package com.wolfcode.test.factory;

public class MyService2 {
    //引入工程类
    private SimpleFactory simpleFactory;
    public void setSimpleFactory(SimpleFactory simpleFactory){
        this.simpleFactory =simpleFactory;
    }
    public void usepay(String payType){
        Pay pay  = simpleFactory.createPay(payType);
        pay.build();
        pay.sign();
        pay.verfifySign();
        pay.createPay();
    }


}
