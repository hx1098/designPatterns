package com.designpatterns.hanxiao.T_11_Filter;

import java.util.List;

/**
 * @author hx
 * @createTime 2021/1/13 11:01
 * @option
 * @description
 */
public class OrCriteria implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;


    public OrCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> people = criteria.meetCriteria(personList);
        List<Person> otherPerple = otherCriteria.meetCriteria(personList);
        for (Person personFor : otherPerple) {
            if (!people.contains(personFor)){
                people.add(personFor);
            }
        }
        return people;
    }
}
