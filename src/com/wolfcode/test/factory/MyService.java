package com.wolfcode.test.factory;

public class MyService {
    public void usePay(String paytype){
        Pay pay = null;
        if("alipay".equals(paytype)){
            pay = new Alipay();
        }
        else if("wechatPay".equals(paytype)){
            pay = new wechatPay();
        }
        //调用其他方法
        pay.build();
        pay.sign();
        pay.verfifySign();
        pay.createPay();
    }

}
