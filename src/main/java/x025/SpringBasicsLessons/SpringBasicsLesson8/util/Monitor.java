package x025.SpringBasicsLessons.SpringBasicsLesson8.util;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class Monitor implements ApplicationListener<ApplicationEvent> {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println(event.getClass().getSimpleName() + " > " + event.getSource().toString());
	};

}
