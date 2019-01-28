package x025.SpringBasicsLessons.SpringBasicsLesson130.loggers;

import x025.SpringBasicsLessons.SpringBasicsLesson130.beans.Event;

public interface EventLogger {

	public void logEvent(Event event);
	
	public String getName();

}
