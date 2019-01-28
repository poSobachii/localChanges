package x025.SpringBasicsLessons.SpringBasicsLesson131.loggers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import x025.SpringBasicsLessons.SpringBasicsLesson131.beans.Event;

@Component
public class ConsoleEventLogger extends AbstractLogger {

    @Override
    public void logEvent(Event event) {
        System.out.println(event.toString());
    }

    @Value("Console logger")
    @Override
    protected void setName(String name) {
        this.name = name;
    }

}
