package com.spring.example.dao.test;


import com.spring.example.beans.test.TestHbaseBean;
import com.spring.example.dao.BaseDao;

import org.apache.hadoop.hbase.client.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TestHbaseDao implements BaseDao<TestHbaseBean> {

    @Autowired
    HbaseTemplate template;


    @Override
    public TestHbaseBean getInfo() {
        
       return template.get("phone2uid", "10361059|20190111", new RowMapper<TestHbaseBean>() {
            @Override
            public TestHbaseBean mapRow(Result result, int rowNum) throws Exception {
                TestHbaseBean testHbaseBean = new TestHbaseBean();
                testHbaseBean.setId(rowNum);
                testHbaseBean.setName(result.toString());
                return testHbaseBean;
            }
        });
    }
}
