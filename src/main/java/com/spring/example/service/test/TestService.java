package com.spring.example.service.test;

import com.spring.example.beans.test.TestBean;
import com.spring.example.dao.BaseDao;
import com.spring.example.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService implements BaseService<TestBean> {

    @Autowired
    private BaseDao<TestBean> baseDao;

    @Override
    public TestBean getInfo() {
        return baseDao.getInfo();
    }
}
