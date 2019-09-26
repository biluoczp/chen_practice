package com.chen.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author chenzepeng
 * @date 2019-08-30
 */
@Service
public class TestService2 {

    @PostConstruct
    public void initIII(){
        System.out.println("dfdfdfdfdf");
    }

    public void test(){
        System.out.println("hello, world22222222");
    }
}
