package x025.SpringBasicsLessons.SpringBasicsLesson8.loggers;

import x025.SpringBasicsLessons.SpringBasicsLesson8.beans.Event;

import java.util.Collection;

public class CombinedEventLogger implements EventLogger {
	
	private final Collection<EventLogger> loggers;
	
	public CombinedEventLogger(Collection<EventLogger> loggers) {
		super();
		this.loggers = loggers;
	}

	@Override
	public void logEvent(Event event) {
		for (EventLogger eventLogger : loggers) {
			eventLogger.logEvent(event);
		}
	}

}
