package com.designpatterns.hanxiao.T_11_Filter;

import java.util.List;

/**
 * @author hx
 * @createTime 2021/1/13 10:57
 * @option
 * @description
 */
public class AndCriteria implements Criteria{

    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> people = criteria.meetCriteria(personList);
        return otherCriteria.meetCriteria(people);
    }
}
