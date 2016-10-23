package com.hc.RXjava.Object;

import java.io.Serializable;

/**
 * @author statham
 * @Email statham@maizuo.com
 * @date 2016/8/30 0030 18:01
 * @Description:
 */
public class User implements Serializable {
    public User(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public User() {
    }

    private String name;
    private String sex;//0 famale 1 male
    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
