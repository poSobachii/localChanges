package x025.SpringBasicsLessons.SpringBasicsLesson100.loggers;

import x025.SpringBasicsLessons.SpringBasicsLesson100.beans.Event;

public class ConsoleEventLogger extends AbstractLogger {

	@Override
	public void logEvent(Event event) {
		System.out.println(event.toString());
	}

}
