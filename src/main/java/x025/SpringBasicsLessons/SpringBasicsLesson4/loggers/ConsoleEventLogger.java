package x025.SpringBasicsLessons.SpringBasicsLesson4.loggers;

import x025.SpringBasicsLessons.SpringBasicsLesson4.beans.Huivent;

public class ConsoleEventLogger implements EventLogger {

	@Override
	public void logEvent(Huivent event) {
		System.out.println(event.toHujing());
	}

}
