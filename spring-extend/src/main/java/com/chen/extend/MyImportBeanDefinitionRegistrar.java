package com.chen.extend;

import com.chen.dao.MyDao;
import com.chen.service.TestService;
import com.chen.util.MyFactoryBean;
import com.chen.util.MyInvocationHandler;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.reflect.Proxy;

/**
 * @author chenzepeng
 * @date 2019-08-29
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {

//        RootBeanDefinition definition = new RootBeanDefinition(TestService.class);
//        registry.registerBeanDefinition("aa", definition);

//        MyDao myDao = (MyDao) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{MyDao.class},
//                new MyInvocationHandler());
//        myDao.hello();

        RootBeanDefinition bd = new RootBeanDefinition(MyDao.class);
        bd.getConstructorArgumentValues().addGenericArgumentValue(bd.getBeanClassName());
        bd.setBeanClass(MyFactoryBean.class);
        registry.registerBeanDefinition("myDao", bd);

    }
}
