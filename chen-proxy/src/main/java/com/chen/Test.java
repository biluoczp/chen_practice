package com.chen;

import com.chen.mapper.ChenDao;
import com.chen.mapper.ChenDaoImpl;
import com.chen.handler.ChenHandler;

import java.lang.reflect.Proxy;

/**
 * @author chenzepeng
 * @date 2019-08-17
 */
public class Test {
    public static void main(String[] args) {
       ChenDaoImpl chenDaoImpl =  new ChenDaoImpl();
        ChenDao dao = (ChenDao) Proxy.newProxyInstance(chenDaoImpl.getClass().getClassLoader(),
                chenDaoImpl.getClass().getInterfaces(),
                new ChenHandler(chenDaoImpl));

        dao.hello();


        System.out.println("ddd \n \t eee");
    }
}
