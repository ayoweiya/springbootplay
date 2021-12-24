package com.wewe.springbootplay.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("=====before advice starts=====");
        System.out.println(getMethodName(joinPoint));
        Arrays.stream(joinPoint.getArgs()).forEach(System.out::println);
        System.out.println("=====before advice ends=====");
    }


    @AfterThrowing(pointcut = "pointcut()", throwing = "ex" )
    public void afterThorwing(JoinPoint joinPoint, Throwable ex) {
        log.error("=====after throwing advice starts Exception=====");
        log.error(getMethodName(joinPoint));
        Arrays.stream(joinPoint.getArgs()).forEach(System.out::println);
        log.error(ex.getMessage());

        log.error("i am e" +  ex.getMessage());
        log.error("=====after throwing advice ends=====");
    }

    private String getMethodName(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return signature.getName();
    }

//    @AfterThrowing(pointcut = "pointcut()", throwing = "throwable" )
//    public void afterThorwing_t(JoinPoint joinPoint, Throwable throwable) {
//        System.out.println("=====after throwing advice starts throwable=====");
//        System.out.println(getMethodName(joinPoint));
//        Arrays.stream(joinPoint.getArgs()).forEach(System.out::println);
//        System.out.println(throwable.getMessage());
//
//        log.error("i am e" +  throwable.getMessage());
//        log.error("=====after throwing advice ends=====");
//    }

//    @Around("pointcut()")
//    public void aroundaround(ProceedingJoinPoint proceedingJoinPoint) {
//        log.error("aroundaround");
//
//        Object value = null;
//        try {
//            value = proceedingJoinPoint.proceed();
//        } catch (Throwable e) {
//            log.info(proceedingJoinPoint.getSignature().getName() + " error");
//
//            String errorMsg = "內部錯誤:" + e.getMessage();
//            String errorCode = "500";
//
//            Map<String, Object> resultMap = new HashMap<String, Object>();
//            resultMap.put("successful", false);
//            resultMap.put("errorCode", errorCode);
//            resultMap.put("errorMsg", errorMsg );
//
//            value = resultMap;
//            log.info((String) value);
//        }
//    }
}
