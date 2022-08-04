package com.wolfcode.spring7;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Hobby {
    @Value("1")
    private Integer hid;
    @Value("rap")
    private String hname;
    @Value("小黑子")
    private String desc;

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "hid=" + hid +
                ", hname='" + hname + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
