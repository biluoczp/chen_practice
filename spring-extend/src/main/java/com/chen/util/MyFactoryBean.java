package com.chen.util;

import com.chen.dao.MyDao;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * @author chenzepeng
 * @date 2019-08-31
 */
public class MyFactoryBean implements FactoryBean, InvocationHandler {

    private Class clazz;

    public MyFactoryBean(Class clazz) {
        this.clazz = clazz;

    }

    @Override
    public Object getObject() throws Exception {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{clazz}, this);
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("sss");
        return null;
    }
}
