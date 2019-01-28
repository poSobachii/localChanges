package x025.SpringBasicsLessons.SpringBasicsLesson7.loggers;

import x025.SpringBasicsLessons.SpringBasicsLesson7.beans.Event;

public class ConsoleEventLogger implements EventLogger {

	@Override
	public void logEvent(Event event) {
		System.out.println(event.toString());
	}

}
