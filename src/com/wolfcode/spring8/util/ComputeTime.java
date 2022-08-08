package com.wolfcode.spring8.util;

import org.springframework.stereotype.Component;

//@Component
public class ComputeTime {
    private Long startTime;
    public void getStartTime(){
        startTime = System.currentTimeMillis();
    }
    public void getEndTime(){
        long endTime = System.currentTimeMillis();
        //做差打印出耗时
        System.out.println((endTime-startTime)+"ms");
    }

}
