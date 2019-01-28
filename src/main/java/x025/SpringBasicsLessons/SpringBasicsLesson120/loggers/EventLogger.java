package x025.SpringBasicsLessons.SpringBasicsLesson120.loggers;

import x025.SpringBasicsLessons.SpringBasicsLesson120.beans.Event;

public interface EventLogger {

	public void logEvent(Event event);
	
	public String getName();

}
