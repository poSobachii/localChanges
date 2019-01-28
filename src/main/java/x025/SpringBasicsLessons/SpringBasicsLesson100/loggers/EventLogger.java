package x025.SpringBasicsLessons.SpringBasicsLesson100.loggers;

import x025.SpringBasicsLessons.SpringBasicsLesson100.beans.Event;

public interface EventLogger {

	public void logEvent(Event event);
	
	public String getName();

}
