package x025.SpringBasicsLessons.SpringBasicsLesson131.loggers;

import x025.SpringBasicsLessons.SpringBasicsLesson131.beans.Event;

public interface EventLogger {

    public void logEvent(Event event);
    
    public String getName();

}
