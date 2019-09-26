package com.chen;

import com.chen.config.AppConfig;
import com.chen.dao.MyDao;
import com.chen.service.TestService;
import com.chen.service.TestService2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author chenzepeng
 * @date 2019-08-29
 */

public class Test {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/chenzepeng/Desktop/spring/");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);



//
//        TestService service = context.getBean(TestService.class);
//        service.test();

//        TestService service1 = (TestService) context.getBean("testService2");
//        service1.test();
//
//        TestService service2 = (TestService) context.getBean("aa");
//        service2.test();

        TestService2 service2 =context.getBean(TestService2.class);
        service2.test();

//
//        MyDao myDao = (MyDao) context.getBean("myDao");
//        myDao.hello();
    }
}

//        TextDao dao = context.getBean(TextDao.class) ;
//        System.out.println(dao.load(1L));
