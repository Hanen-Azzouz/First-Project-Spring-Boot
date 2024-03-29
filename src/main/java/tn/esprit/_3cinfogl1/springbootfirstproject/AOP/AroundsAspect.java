package tn.esprit._3cinfogl1.springbootfirstproject.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AroundsAspect {

    @Around("execution(* tn.esprit._3CinfoGL1.SpringBootFirstProject.Services.EquipeService.addEquipe(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable
    {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method"+pjp.getSignature().getName()+ "execution time: " + elapsedTime + "milliseconds.");
        return obj;
    }

}
