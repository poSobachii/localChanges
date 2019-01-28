package x025.SpringBasicsLessons.SpringBasicsLesson120.loggers;

import x025.SpringBasicsLessons.SpringBasicsLesson120.beans.Event;

public class ConsoleEventLogger extends AbstractLogger {

	@Override
	public void logEvent(Event event) {
		System.out.println(event.toString());
	}

}
