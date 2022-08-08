package com.wolfcode.spring8.util2;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ComputeTime {
    private Long startTime;
    //定义一个无返回值的方法//表示一个切点
    @Pointcut("execution(* com.wolfcode.spring8.service.impl.UserServiceImpl.addUser(..))")
    public void pointCunt(){}
    @Before("pointCunt()")
    public void getStartTime(){
        startTime = System.currentTimeMillis();
    }
    @AfterReturning("pointCunt()")
    @AfterThrowing("pointCunt()")
    public void getEndTime(){
        long endTime = System.currentTimeMillis();
        //做差打印出耗时
        System.out.println((endTime-startTime)+"ms");
    }

}
