package com.wolfcode.spring5;

public class Person3 {
    private Integer id;
    private String name;
    private Hobby hobby;

    public Person3() {
    }

    public Person3(Integer id, String name, Hobby hobby) {
        this.id = id;
        this.name = name;
        this.hobby = hobby;
    }

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person3{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hobby=" + hobby +
                '}';
    }
}
