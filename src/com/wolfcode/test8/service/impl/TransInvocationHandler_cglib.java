package com.wolfcode.test8.service.impl;


import com.wolfcode.test8.util.MyTransManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * cglib动态代理实现
 */
@Component("transInvocationHandler_cglib")
public class TransInvocationHandler_cglib implements InvocationHandler {
    @Autowired
    @Qualifier("userServiceImpl")
    private Object target;

    public Object getTarget() {
        return target;
    }
    //引入跟事物相关的事物管理器
    @Autowired
    MyTransManager myTransManager;
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        Object value=null;
        try {
            myTransManager.startTrans();
            value = method.invoke(target, objects);
            myTransManager.commit();
        }catch (Exception e){
            myTransManager.rollback();
    }
        return value;
}
}
