package com.example.foyerrouamnissi.AOP;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class FoyerAspect {
    @Before("execution(* com.example.foyerrouamnissi.Services.Foyer.*.*(..))")
    public  void method(JoinPoint jp)
    {
        log.info("hello"+jp.getSignature().getName());
    }

}
