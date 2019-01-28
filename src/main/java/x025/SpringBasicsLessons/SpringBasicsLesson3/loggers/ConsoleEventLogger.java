package x025.SpringBasicsLessons.SpringBasicsLesson3.loggers;

public class ConsoleEventLogger implements EventLogger {

	@Override
	public void logEvent(String msg) {
		System.out.println(msg);
	}

}
