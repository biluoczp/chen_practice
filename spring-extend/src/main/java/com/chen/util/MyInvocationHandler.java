package com.chen.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author chenzepeng
 * @date 2019-08-31
 */
public class MyInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("hhhl");
        return null;
    }
}
