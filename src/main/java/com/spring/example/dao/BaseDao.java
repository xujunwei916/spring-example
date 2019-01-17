package com.spring.example.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface BaseDao<T> {
    public T getInfo();
}
