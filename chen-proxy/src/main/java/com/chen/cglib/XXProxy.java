package com.chen.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author chenzepeng
 * @date 2019-09-17
 */
public class XXProxy implements MethodInterceptor {

    private Object srcTarget;
    public XXProxy(Object o){
        this.srcTarget = o;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        System.out.println("aaa3");
        Object o = method.invoke(srcTarget, args);
        System.out.println("aa4");
        return o;
    }
}
