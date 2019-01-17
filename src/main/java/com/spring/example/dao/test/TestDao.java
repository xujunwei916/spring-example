package com.spring.example.dao.test;

import com.spring.example.beans.test.TestBean;
import com.spring.example.dao.BaseDao;

import org.springframework.stereotype.Repository;

@Repository
public class TestDao implements BaseDao<TestBean> {

    @Override
    public TestBean getInfo() {
        TestBean testBean = new TestBean();
        testBean.setId((int) (System.currentTimeMillis() % 1000));
        testBean.setName("你好 ： " + testBean.getId());
        return testBean;
    }
}
