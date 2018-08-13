package com.cenyol.example.model.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import javax.management.MXBean;
import org.aspectj.lang.annotation.*;
/**
 * @author Cenyol mail: mr.cenyol@gmail.com
 * @date 07/08/2017 11:26
 */
@Component
public class Audience {

    @Pointcut("execution(* com.cenyol.example.model.aspectj.Performance.perform(..))")
    public void performance() {}

    @Before("execution(* com.cenyol.example.model.aspectj.Performance.perform(..))")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phone");
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking seats");
    }
    @AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP !!!");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }
//    public void watchPerformance(ProceedingJoinPoint joinPoint) {
//        System.out.println("Silencing cell phone");
//        System.out.println("Taking seats");
//        try {
//            joinPoint.proceed();
//            System.out.println("CLAP CLAP CLAP !!!");
//        } catch (Throwable throwable) {
//            System.out.println("Demanding a refund");
//        }
//    }
}
