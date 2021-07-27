package com.codegym.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import java.time.LocalDate;


@Component
@Aspect
public class Logger {
    int count = 0;

    @Pointcut("within(com.codegym.controller.BookController*)")
    public void addAllMethodsPointcut() {
    }

    @After("addAllMethodsPointcut()")
    public void callAllMethod(JoinPoint joinPoint) {
        count ++;
        System.err.println("time : " + LocalDate.now() + " -" + " method : " + joinPoint.getSignature().getName() +
                " -" + " so luong truy cap : " + count);
    }

    @Pointcut("execution(* com.codegym.controller.BookController.borrow(..))")
    public void borrowPointcut() {
    }

    @AfterReturning("borrowPointcut()")
    public void callAfterBorrow(JoinPoint joinPoint){
        System.err.println("class name: " + joinPoint.getSignature().getDeclaringTypeName() +
                " -" + " method : " + joinPoint.getSignature().getName() +
                " -" + " time: " + LocalDate.now());
    }

    @Pointcut("execution(* com.codegym.controller.BookController.giveBookBack(..))")
    public void giveBookBackPointcut() {
    }

    @AfterReturning("giveBookBackPointcut()")
    public void callAfterGiveBack(JoinPoint joinPoint){
        System.err.println("class name: " + joinPoint.getSignature().getDeclaringTypeName() +
                " -" + " method : " + joinPoint.getSignature().getName() +
                " -" + " time: " + LocalDate.now());
    }
}
