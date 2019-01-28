package x025.SpringBasicsLessons.SpringBasicsLesson101.loggers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import x025.SpringBasicsLessons.SpringBasicsLesson101.beans.Event;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;

@Component
public class CombinedEventLogger extends AbstractLogger {

    @Resource(name = "combinedLoggers")
    private Collection<EventLogger> loggers;

    @Override
    public void logEvent(Event event) {
        for (EventLogger eventLogger : loggers) {
            eventLogger.logEvent(event);
        }
    }

    public Collection<EventLogger> getLoggers() {
        return Collections.unmodifiableCollection(loggers);
    }
    
    @Value("#{'Combined ' + combinedEventLogger.loggers.![name].toString()}")
    @Override
    protected void setName(String name) {
        this.name = name;
    }

}