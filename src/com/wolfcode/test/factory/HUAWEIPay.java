package com.wolfcode.test.factory;

public class HUAWEIPay extends Pay{

    @Override
    public void build() {
        System.out.println("华为支付");
    }
}
