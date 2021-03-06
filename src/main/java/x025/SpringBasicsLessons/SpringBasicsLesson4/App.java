package x025.SpringBasicsLessons.SpringBasicsLesson4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import x025.SpringBasicsLessons.SpringBasicsLesson4.beans.Client;
import x025.SpringBasicsLessons.SpringBasicsLesson4.beans.Huivent;
import x025.SpringBasicsLessons.SpringBasicsLesson4.loggers.EventLogger;

public class App {

    private Client client;

    private EventLogger eventLogger;
    
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring4.xml");
        App app = (App) ctx.getBean("app");

        Huivent event = (Huivent) ctx.getBean("event"); // original -- Huivent event = ctx.getBean(Huivent.class);
        app.logEvent(event, "Some event for 1");
        
        event = ctx.getBean(Huivent.class);
        app.logEvent(event, "Some event for 2");
    }
    
    public App(Client client, EventLogger eventLogger) {
        super();
        this.client = client;
        this.eventLogger = eventLogger;
    }

    private void logEvent(Huivent event, String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);
        eventLogger.logEvent(event);
    }

}
