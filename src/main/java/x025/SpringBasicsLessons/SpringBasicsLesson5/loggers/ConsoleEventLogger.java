package x025.SpringBasicsLessons.SpringBasicsLesson5.loggers;

import x025.SpringBasicsLessons.SpringBasicsLesson5.beans.Huent;
import x025.SpringBasicsLessons.SpringBasicsLesson5.beans.Client;

public class ConsoleEventLogger implements EventLoggerINTRAFACE {

	public void logEvent(Huent event) {
		System.out.println(event.toString());
	}

	public void starting(){
		Client.TimeCheck("ConsoleEventLogger bean");
	}

}
