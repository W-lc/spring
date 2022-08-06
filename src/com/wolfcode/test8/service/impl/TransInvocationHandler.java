package com.wolfcode.test8.service.impl;

import com.wolfcode.test8.util.MyTransManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 事物管理增强的一个模版
 * 事物管理增强的工具类
 * ----不是一个代理类
 */
@Component
public class TransInvocationHandler implements InvocationHandler {
    //引入真实的业务对象
    @Autowired
    @Qualifier("userServiceImpl")
    private Object target;
    @Autowired
    MyTransManager myTransManager;
    //引入事务管理器-需要增强的功能
    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object value=null;
        try {
            myTransManager.startTrans();
            value = method.invoke(target, args);
            myTransManager.commit();
        }catch (Exception e){
            myTransManager.rollback();
        }
        return value;
    }
}
