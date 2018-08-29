package com.ls.demo.test.pojo;

/**
 * @Description:
 * @Author Created by liangjunwei on 2018/8/23 11:17
 */
public class Person {
    private String name;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "I am a person, my name is " + name;
    }
}