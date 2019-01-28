package x025.SpringBasicsLessons.SpringBasicsLesson2.beans;

public class ConsoleEventLogger implements EventLogger {

	@Override
	public void logEvent(String msg) {
		System.out.println(msg);
	}

}
