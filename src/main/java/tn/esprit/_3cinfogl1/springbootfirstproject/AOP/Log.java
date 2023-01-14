package tn.esprit._3cinfogl1.springbootfirstproject.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class Log {


    @Before("execution(* tn.esprit._3CinfoGL1.SpringBootFirstProject.Services.EquipeService.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }

    @After("execution(* tn.esprit._3CinfoGL1.SpringBootFirstProject.Services.*(..))")
    public void logMethodEnd(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Out method " + name + " : ");
    }

}


