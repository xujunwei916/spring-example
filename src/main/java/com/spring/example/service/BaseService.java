package com.spring.example.service;

import org.springframework.stereotype.Service;

@Service
public interface BaseService<T> {

    public T getInfo();
}
