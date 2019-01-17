package com.spring.example.beans.conf;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.hadoop.hbase.HbaseTemplate;

@Configuration
public class ConfigurationBeans {


    @Autowired
    org.apache.hadoop.conf.Configuration conf;


    @Bean
    org.apache.hadoop.conf.Configuration configuration(){

        return HBaseConfiguration.create();
    }



    @Bean
    HbaseTemplate htemplate(){

      return  new  HbaseTemplate(conf);
    }

//    DataSource dataSource(){
//        Proer
//        DataSource dataSource = BasicDataSourceFactory.createDataSource(props);
//        return dataSource;
//    }

}
