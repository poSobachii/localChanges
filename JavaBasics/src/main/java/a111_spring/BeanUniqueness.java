package a111_spring;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class BeanUniqueness {

    Date date;

    public BeanUniqueness() {
        long duration = System.currentTimeMillis();
        this.date = new Date(duration);
    }

    public void printCreatingTime() {
        DateFormat simple = new SimpleDateFormat("HH:mm:ss:SSS");
        System.out.println("Creating time: " + simple.format(date));
    }

}
