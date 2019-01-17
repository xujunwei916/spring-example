package com.spring.example.service.test;

import com.spring.example.beans.test.TestBean;
import com.spring.example.beans.test.TestHbaseBean;
import com.spring.example.dao.BaseDao;
import com.spring.example.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestHbaseService implements BaseService<TestHbaseBean> {

    @Autowired
    private BaseDao<TestHbaseBean> baseDao;

    @Override
    public TestHbaseBean getInfo() {
        return baseDao.getInfo();
    }
}
