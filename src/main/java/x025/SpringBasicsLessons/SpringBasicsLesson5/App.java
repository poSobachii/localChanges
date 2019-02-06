package x025.SpringBasicsLessons.SpringBasicsLesson5;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import x025.SpringBasicsLessons.SpringBasicsLesson5.beans.Client;
import x025.SpringBasicsLessons.SpringBasicsLesson5.beans.Huent;
import x025.SpringBasicsLessons.SpringBasicsLesson5.loggers.EventLoggerINTRAFACE;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {

    private Client client;

    private EventLoggerINTRAFACE eventLogger;
    
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring5.xml");
        App app = (App) ctx.getBean("app");
        
        Huent event = ctx.getBean(Huent.class);
        app.logEventMethod(event, "Some event for 1");
        
        event = ctx.getBean(Huent.class);
        app.logEventMethod(event, "Some event for 2");
        
        ctx.close();
    }
    
    public App(Client client, EventLoggerINTRAFACE eventLogger) {
        super();
        this.client = client;
        this.eventLogger = eventLogger;
    }

    private void logEventMethod(Huent event, String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);
        eventLogger.logEvent(event);
    }

    private void starting(){
        Client.TimeCheck("App bean");
    }

}
