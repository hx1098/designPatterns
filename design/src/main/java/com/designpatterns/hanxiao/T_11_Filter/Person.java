package com.designpatterns.hanxiao.T_11_Filter;

import java.time.Period;

/**
 * @author hx
 * @createTime 2021/1/12 17:33
 * @option 过滤器模式
 * @description
 */
public class Person {

    private String name;
    private String gender;
    private String maritalStatus;

    public Person(String name, String gender, String maritalStatus) {
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }
}
