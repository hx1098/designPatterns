package com.designpatterns.hanxiao.T_11_Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hx
 * @createTime 2021/1/12 17:46
 * @option
 * @description 过滤出女性
 */
public class FEMaleCriteria implements Criteria{

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> persons = new ArrayList<>();
        for (Person person : personList) {
            if (person.getGender().equalsIgnoreCase("FEMALE")){
                persons.add(person);
            }
        }
        return persons;
    }
}
