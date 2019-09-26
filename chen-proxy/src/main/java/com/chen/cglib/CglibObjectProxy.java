package com.chen.cglib;

/**
 * @author chenzepeng
 * @date 2019-09-17
 */

import java.lang.reflect.Method;

import com.chen.mapper.ChenDaoImpl;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibObjectProxy implements MethodInterceptor {


    private Object srcTarget;

    private CglibObjectProxy(Object o) {
        this.srcTarget = o;
    }

    @SuppressWarnings("unchecked")
    public static <T> T proxyTarget(T t) {
        Enhancer en = new Enhancer();
        en.setSuperclass(t.getClass());
        en.setCallback(new CglibObjectProxy(t));
        T tt = (T) en.create();
        return tt;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {

        System.out.println("33");
        Object o = method.invoke(srcTarget, args);
        System.out.println("444");
        return o;
    }


    public static void main(String[] args) {
        // 未实现接口的类的代理
        ChenDaoImpl proxyPerson = CglibObjectProxy.proxyTarget(new ChenDaoImpl());
        proxyPerson.hello();

    }


}
