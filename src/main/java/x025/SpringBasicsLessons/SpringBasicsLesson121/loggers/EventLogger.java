package x025.SpringBasicsLessons.SpringBasicsLesson121.loggers;

import x025.SpringBasicsLessons.SpringBasicsLesson121.beans.Event;

public interface EventLogger {

    public void logEvent(Event event);
    
    public String getName();

}
