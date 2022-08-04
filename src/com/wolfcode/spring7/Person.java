package com.wolfcode.spring7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Repository
//@Service
//@Controller
@Component
public class Person {
    @Value("张三")
    private String name;
    @Value("1")
    private Integer id;
    @Autowired
    private Hobby hobby;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", hobby=" + hobby +
                '}';
    }
}
