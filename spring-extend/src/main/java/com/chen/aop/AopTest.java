package com.chen.aop;

import lombok.Builder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * @author chenzepeng
 * @date 2019-09-06
 */
@Component
@Aspect
public class AopTest {

    @Pointcut("execution(public * com.chen.service..*(..))")
    private void servicePointcut() {
    }

    @Before("servicePointcut()")
    public void sss(){
        System.out.println("dddddddddd");
    }


    @Around("servicePointcut()")
    public Object doAround(ProceedingJoinPoint pjp) {
        System.out.println("hello aop =----");
        try {
            return pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("fffffff =----");
        return null;
    }
}
