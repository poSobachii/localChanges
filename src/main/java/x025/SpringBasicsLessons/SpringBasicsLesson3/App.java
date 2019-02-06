package x025.SpringBasicsLessons.SpringBasicsLesson3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import x025.SpringBasicsLessons.SpringBasicsLesson3.beans.Client;
import x025.SpringBasicsLessons.SpringBasicsLesson3.loggers.EventLogger;

public class App {

    private Client client;

    private EventLogger eventLogger;
    
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring3.xml");
        App app = (App) ctx.getBean("app");
        
        app.logEvent("Some event for 1 and He is 1");
        app.logEvent("Some event for 2 and He is 2");
    }
    
    public App(Client client, EventLogger eventLogger) {
        super();
        this.client = client;
        this.eventLogger = eventLogger;
    }

    private void logEvent(String msg) {
        String message = msg.replaceFirst(client.getId(), client.getFullName()).replaceFirst(client.getId(), client.getAge());
        eventLogger.logEvent(message);
    }

}
