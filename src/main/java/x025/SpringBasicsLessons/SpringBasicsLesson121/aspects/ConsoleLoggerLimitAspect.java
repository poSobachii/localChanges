package x025.SpringBasicsLessons.SpringBasicsLesson121.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import x025.SpringBasicsLessons.SpringBasicsLesson121.beans.Event;
import x025.SpringBasicsLessons.SpringBasicsLesson121.loggers.EventLogger;

@Aspect
@Component
public class ConsoleLoggerLimitAspect {

    private final int maxCount;

    private final EventLogger otherLogger;

    private int currentCount = 0;

    @Autowired
    public ConsoleLoggerLimitAspect(
            @Value("${console.logger.max:2}") int maxCount, 
            @Qualifier("fileEventLogger") EventLogger otherLogger) {
        this.maxCount = maxCount;
        this.otherLogger = otherLogger;
    }

    @Around("execution(* *.logEvent(x025.SpringBasicsLessons.SpringBasicsLesson121.beans.Huent)) "
            + "&& within(x025.SpringBasicsLessons.SpringBasicsLesson121.loggers.ConsoleEventLogger) "
            + "&& args(evt)")
    public void aroundLogEvent(ProceedingJoinPoint jp, Event evt) throws Throwable {
        if (currentCount < maxCount) {
            System.out.println("ConsoleEventLogger max count is not reached. Continue...");
            currentCount++;
            jp.proceed(new Object[] { evt });
        } else {
            System.out.println("ConsoleEventLogger max count is reached. Logging to " + otherLogger.getName());
            otherLogger.logEvent(evt);
        }
    }

}