package ru.SpringControlWork.SpringControlWork.aspects;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

    @AfterReturning(value="@annotation(TrackUserAction)", returning = "returning")
    public void log(JoinPoint joinPoint, Object returning){
        System.out.println("Метод " + joinPoint.getSignature().getName()+" был вызван\nВернул "
                +returning.getClass());
    }

    @AfterThrowing(value="@annotation(TrackUserAction)", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex){
        System.out.println("Метод " + joinPoint.getSignature().getName()+" вернул исключение "
                +ex.getClass() +" "+ex.getMessage());
    }
}