package x025.SpringBasicsLessons.SpringBasicsLesson9.loggers;

import org.springframework.stereotype.Component;
import x025.SpringBasicsLessons.SpringBasicsLesson9.beans.Event;

import javax.annotation.Resource;
import java.util.Collection;

@Component
public class CombinedEventLogger implements EventLogger {

    @Resource(name = "combinedLoggers")
    private Collection<EventLogger> loggers;

    @Override
    public void logEvent(Event event) {
        for (EventLogger eventLogger : loggers) {
            eventLogger.logEvent(event);
        }
    }

}