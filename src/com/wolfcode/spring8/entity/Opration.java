package com.wolfcode.spring8.entity;

public class Opration {
    private Integer id;
    private String opration;
    private Integer uid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpration() {
        return opration;
    }

    public void setOpration(String opration) {
        this.opration = opration;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Opration{" +
                "id=" + id +
                ", opration='" + opration + '\'' +
                ", uid=" + uid +
                '}';
    }
}
