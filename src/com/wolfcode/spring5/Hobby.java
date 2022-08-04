package com.wolfcode.spring5;

public class Hobby {
    private Integer hid;
    private String hname;
    private String hdesc;

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

    public String getHdesc() {
        return hdesc;
    }

    public void setHdesc(String hdesc) {
        this.hdesc = hdesc;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "hid=" + hid +
                ", hname='" + hname + '\'' +
                ", hdesc='" + hdesc + '\'' +
                '}';
    }
}
