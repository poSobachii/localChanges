package x025.SpringBasicsLessons.SpringBasicsLesson5;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import x025.SpringBasicsLessons.SpringBasicsLesson5.beans.Client;
import x025.SpringBasicsLessons.SpringBasicsLesson5.beans.Event;
import x025.SpringBasicsLessons.SpringBasicsLesson5.loggers.EventLogger;

public class App {

    private Client client;

    private EventLogger eventLogger;
    
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring5.xml");
        App app = (App) ctx.getBean("app");
        
        Event event = ctx.getBean(Event.class);
        app.logEvent(event, "Some event for 1");
        
        event = ctx.getBean(Event.class);
        app.logEvent(event, "Some event for 2");
        
        ctx.close();
    }
    
    public App(Client client, EventLogger eventLogger) {
        super();
        this.client = client;
        this.eventLogger = eventLogger;
    }

    private void logEvent(Event event, String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);
        eventLogger.logEvent(event);
    }

}
