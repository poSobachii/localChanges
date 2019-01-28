package x025.SpringBasicsLessons.SpringBasicsLesson4.loggers;

import x025.SpringBasicsLessons.SpringBasicsLesson4.beans.Event;

public class ConsoleEventLogger implements EventLogger {

	@Override
	public void logEvent(Event event) {
		System.out.println(event.toString());
	}

}
