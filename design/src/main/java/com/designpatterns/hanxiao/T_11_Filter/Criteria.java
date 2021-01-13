package com.designpatterns.hanxiao.T_11_Filter;

import java.util.List;

/**
 * @author hx
 * @createTime 2021/1/12 17:41
 * @option 过滤器模式
 * @description 创建条件接口
 */
public interface Criteria {

    public List<Person> meetCriteria(List<Person> personList);
}
