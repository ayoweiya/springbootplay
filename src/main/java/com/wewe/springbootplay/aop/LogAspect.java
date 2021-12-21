package com.wewe.springbootplay.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class LogAspect {
    @Pointcut("execution(* com.wewe.springbootplay.service..*.*(..))")
    public void pointcut() {
    }

//    @Before("pointcut()")
//    public void before(JoinPoint joinPoint) {
//        System.out.println("=====before advice starts=====");
//        System.out.println(getMethodName(joinPoint));
//        Arrays.stream(joinPoint.getArgs()).forEach(System.out::println);
//        System.out.println("=====before advice ends=====");
//    }


    @AfterThrowing(pointcut = "pointcut()", throwing = "throwable")
    public void afterThorwing(JoinPoint joinPoint, Throwable throwable) {
        System.out.println("=====after throwing advice starts=====");
        System.out.println(getMethodName(joinPoint));
        Arrays.stream(joinPoint.getArgs()).forEach(System.out::println);
        System.out.println(throwable.getMessage());
        System.out.println("=====after throwing advice ends=====");
    }

    private String getMethodName(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return signature.getName();
    }
}
