package com.chen.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author chenzepeng
 * @date 2019-08-17
 */
public class ChenHandler implements InvocationHandler {

    private Object target;

    public ChenHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }
}
