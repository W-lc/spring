package com.wolfcode.spring3;

public class MyJDBC {
    public MyJDBC(){
        System.out.println("创建JDBC对象");
    }
    public void init(){
        System.out.println("初始化操作");
    }
    public void getConnetion(){
        System.out.println("获取链接");
    }
    public void close(){
        System.out.println("关闭链接的方法");
    }
}
