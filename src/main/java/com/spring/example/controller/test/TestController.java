package com.spring.example.controller.test;

import com.spring.example.beans.test.TestBean;
import com.spring.example.beans.test.TestHbaseBean;
import com.spring.example.controller.BaseController;
import com.spring.example.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController implements BaseController<TestBean> {

    @Autowired
    private BaseService<TestBean> testService;


    @Autowired
    private BaseService<TestHbaseBean> hbaseService;

    @RequestMapping("/")
    public String index() {
        return "欢迎使用Spring的测试系统!";
    }

    @Override
    @RequestMapping("/info")
    public TestBean getInfo() {
        return testService.getInfo();
    }


    @RequestMapping("/hbase")
    public TestHbaseBean getHbase() {
        return hbaseService.getInfo();
    }
}
