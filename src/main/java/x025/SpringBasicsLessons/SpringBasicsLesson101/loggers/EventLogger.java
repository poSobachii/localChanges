package x025.SpringBasicsLessons.SpringBasicsLesson101.loggers;

import x025.SpringBasicsLessons.SpringBasicsLesson101.beans.Event;

public interface EventLogger {

    public void logEvent(Event event);
    
    public String getName();

}
