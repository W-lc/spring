package com.wolfcode.test.factory;
//支付类型
public abstract class Pay {
    //该方法必须被重写
    public abstract void build();
    //签名
    public void sign(){
        System.out.println("执行签名");
    }
    //校验签名
    public void verfifySign(){
        System.out.println("校验签名");
    }
    //预支付
    public void createPay(){
        System.out.println("创建预支付订单");
    }
}
class Alipay extends Pay{

    @Override
    public void build() {
        System.out.println("支付宝支付");
    }
}
class wechatPay extends Pay{

    @Override
    public void build() {
        System.out.println("微信支付");
    }
}
