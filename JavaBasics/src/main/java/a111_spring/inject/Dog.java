package a111_spring.inject;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;
import javax.inject.Singleton;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//@Component
public class Dog {

    public void bark() {
        System.out.println("Dog says whoof whoof");
    }


    String name;
    Date date;

    public Dog() {
        long duration = System.currentTimeMillis();
        this.date = new Date(duration);
    }

    public Dog(String name) {
        this.name = name;
        long duration = System.currentTimeMillis();
        this.date = new Date(duration);
    }

    public String getName() {
        DateFormat simple = new SimpleDateFormat("HH:mm:ss:SSS");
        System.out.println("Creating time: " + simple.format(date));
        return name;
    }

}
