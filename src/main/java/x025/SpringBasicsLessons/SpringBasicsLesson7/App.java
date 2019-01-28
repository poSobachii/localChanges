package x025.SpringBasicsLessons.SpringBasicsLesson7;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import x025.SpringBasicsLessons.SpringBasicsLesson7.beans.Client;
import x025.SpringBasicsLessons.SpringBasicsLesson7.beans.Event;
import x025.SpringBasicsLessons.SpringBasicsLesson7.beans.EventType;
import x025.SpringBasicsLessons.SpringBasicsLesson7.loggers.EventLogger;

import java.util.Map;

public class App {

    private Client client;

    private EventLogger defaultLogger;

    private Map<EventType, EventLogger> loggers;
    
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring7.xml");
        App app = (App) ctx.getBean("app");
        
        Event event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "Some event for 1");
        
        event = ctx.getBean(Event.class);
        app.logEvent(EventType.ERROR, event, "Some event for 2");
        
        event = ctx.getBean(Event.class);
        app.logEvent(null, event, "Some event for 3");
        
        ctx.close();
    }
    
    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        super();
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
    }

    private void logEvent(EventType eventType, Event event, String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);
        
        EventLogger logger = loggers.get(eventType);
        if (logger == null) {
            logger = defaultLogger;
        }
        
        logger.logEvent(event);
    }

}
