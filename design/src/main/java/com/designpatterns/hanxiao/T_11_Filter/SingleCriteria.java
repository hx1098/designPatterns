package com.designpatterns.hanxiao.T_11_Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hx
 * @createTime 2021/1/13 10:51
 * @option
 * @description 过滤出单身的
 */
public class SingleCriteria implements Criteria{

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> singlePerson = new ArrayList<>();
        for (Person person : personList) {
            if (person.getMaritalStatus().equalsIgnoreCase("single")){
                singlePerson.add(person);
            }
        }
        return singlePerson;
    }
}
