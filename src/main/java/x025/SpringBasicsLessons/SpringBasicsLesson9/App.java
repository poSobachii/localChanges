package x025.SpringBasicsLessons.SpringBasicsLesson9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import x025.SpringBasicsLessons.SpringBasicsLesson9.beans.Client;
import x025.SpringBasicsLessons.SpringBasicsLesson9.beans.Event;
import x025.SpringBasicsLessons.SpringBasicsLesson9.beans.EventType;
import x025.SpringBasicsLessons.SpringBasicsLesson9.loggers.EventLogger;
import x025.SpringBasicsLessons.SpringBasicsLesson9.spring.AppConfig;
import x025.SpringBasicsLessons.SpringBasicsLesson9.spring.LoggerConfig;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class App {

    @Autowired
    private Client client;

    @Resource(name = "defaultLoggerss")
    private EventLogger defaultLogger;

    @Resource(name = "loggerMap")
    private Map<EventType, EventLogger> loggers;

    public App() {
    }

    App(Client client, EventLogger defaultLogger,
            Map<EventType, EventLogger> loggersMap) {
        this.client = client;
        this.defaultLogger = defaultLogger;
        this.loggers = loggersMap;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class, LoggerConfig.class);
        ctx.scan("x025/SpringBasicsLessons/SpringBasicsLesson9");
        ctx.refresh();

        App app = (App) ctx.getBean("app");

        Client client = ctx.getBean(Client.class);
        System.out.println("Client says: " + client.getGreeting());

        Event event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "Some event for 1");

        event = ctx.getBean(Event.class);
        app.logEvent(EventType.ERROR, event, "Some event for 2");

        event = ctx.getBean(Event.class);
        app.logEvent(null, event, "Some event for 3");

        ctx.close();
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