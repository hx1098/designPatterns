package com.designpatterns.hanxiao.T_11_Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hx
 * @createTime 2021/1/12 17:46
 * @option
 * @description 过滤出男性
 */
public class MaleCriteria  implements Criteria{

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> persons = new ArrayList<>();
        for (Person person : personList) {
            if (person.getGender().equalsIgnoreCase("MALE")){
                persons.add(person);
            }
        }
        return persons;
    }
}
