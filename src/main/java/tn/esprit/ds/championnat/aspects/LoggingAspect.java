package tn.esprit.ds.championnat.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    // Pointcut that targets all methods in the services package
    @Pointcut("execution(* tn.esprit.ds.championnat.services.*.*(..))")
    public void serviceMethods() {}

    @Before("serviceMethods()")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Entrée dans la méthode : " + name);
    }

    @After("serviceMethods()")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Sortie de la méthode (avec ou sans exception) : " + name);
    }

    @AfterReturning("serviceMethods()")
    public void logMethodAfterReturning(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Méthode exécutée avec succès : " + name);
    }

    @AfterThrowing(pointcut = "serviceMethods()", throwing = "ex")
    public void logMethodAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        String name = joinPoint.getSignature().getName();
        log.error("Exception levée dans la méthode " + name + " : " + ex.getMessage());
    }

    @Around("serviceMethods()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        // Allow the method to execute
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Temps d'exécution de la méthode " + pjp.getSignature().getName() + " : " + elapsedTime + " millisecondes.");
        return obj;
    }
}
