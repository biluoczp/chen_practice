package com.chen;

import com.chen.config.AppConfig;
import com.chen.service.TestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author chenzepeng
 * @date 2019-08-29
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        TextDao dao = context.getBean(TextDao.class) ;
//        System.out.println(dao.load(1L));

//        TestService service = context.getBean(TestService.class);
//        service.test();

        TestService service1 = (TestService) context.getBean("testService2");
        service1.test();

        TestService service2 = (TestService) context.getBean("aa");
        service2.test();

    }
}
