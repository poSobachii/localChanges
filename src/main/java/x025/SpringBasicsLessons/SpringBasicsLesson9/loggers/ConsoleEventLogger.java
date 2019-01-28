package x025.SpringBasicsLessons.SpringBasicsLesson9.loggers;

import org.springframework.stereotype.Component;
import x025.SpringBasicsLessons.SpringBasicsLesson9.beans.Event;

@Component
public class ConsoleEventLogger implements EventLogger {

    @Override
    public void logEvent(Event event) {
        System.out.println(event.toString());
    }

}
