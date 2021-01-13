package com.designpatterns.hanxiao.T_12_Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hx
 * @createTime 2021/1/13 14:35
 * @option 组合模式
 * @description
 */
public class Employee {

    /***/
    private String name;
    /**部门*/
    private String dept;
    /**薪水*/
    private int salary;
    /**下属*/
    private List<Employee> subordinates;

    public Employee(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        subordinates = new ArrayList<Employee>();
    }

    public void add(Employee e) {
        subordinates.add(e);
    }

    public void remove(Employee e) {
        subordinates.remove(e);
    }


    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public String toString(){
        return ("Employee :[ Name : "+ name
                +", dept : "+ dept + ", salary :"
                + salary+" ]");
    }


}
