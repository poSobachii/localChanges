package x025.SpringBasicsLessons.SpringBasicsLesson120;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import x025.SpringBasicsLessons.SpringBasicsLesson120.aspects.StatisticsAspect;
import x025.SpringBasicsLessons.SpringBasicsLesson120.beans.Client;
import x025.SpringBasicsLessons.SpringBasicsLesson120.beans.Event;
import x025.SpringBasicsLessons.SpringBasicsLesson120.beans.EventType;
import x025.SpringBasicsLessons.SpringBasicsLesson120.loggers.EventLogger;

import java.util.Map;
import java.util.Map.Entry;

public class App {

    private Client client;

    private EventLogger defaultLogger;

    private Map<EventType, EventLogger> loggers;
    
    private String startupMessage;
    
    private StatisticsAspect statisticsAspect;
    
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring120.xml");
        App app = (App) ctx.getBean("app");
        
        System.out.println(app.startupMessage);
        
        Client client = ctx.getBean(Client.class);
        System.out.println("Client says: " + client.getGreeting());
        
        Event event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "Some event for 1");
        
        event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "One more event for 1");
        
        event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "And one more event for 1");
        
        event = ctx.getBean(Event.class);
        app.logEvent(EventType.ERROR, event, "Some event for 2");
        
        event = ctx.getBean(Event.class);
        app.logEvent(null, event, "Some event for 3");
        
        app.outputLoggingCounter();
        
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
    
    private void outputLoggingCounter() {
        if (statisticsAspect != null) {
            System.out.println("Loggers statistics. Number of calls: ");
            for (Entry<Class<?>, Integer> entry: statisticsAspect.getCounter().entrySet()) {
                System.out.println("    " + entry.getKey().getSimpleName() + ": " + entry.getValue());
            }
        }
    }

    public void setStartupMessage(String startupMessage) {
        this.startupMessage = startupMessage;
    }
    
    public void setStatisticsAspect(StatisticsAspect statisticsAspect) {
        this.statisticsAspect = statisticsAspect;
    }

    public EventLogger getDefaultLogger() {
        return defaultLogger;
    }

}
