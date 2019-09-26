package com.chen.extend;

import com.chen.service.TestService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author chenzepeng
 * @date 2019-08-29
 */
//@Component
public class MyBeanFactory implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        if (beanFactory.containsBeanDefinition("testService2")) {
            GenericBeanDefinition bd = (GenericBeanDefinition) beanFactory.getBeanDefinition("testService2");
            bd.setBeanClass(TestService.class);
        }
    }
}
