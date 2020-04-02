package a80_date_time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeCheckMethod {

    public static void main(String[] args) {
        TimeCheck("This is just a text");
    }

    public static void TimeCheck(String text) {
        long duration = System.currentTimeMillis();
        DateFormat simple = new SimpleDateFormat("HH:mm:ss:SSS");
        Date result = new Date(duration);
        System.out.println( simple.format(result) + " " + text);
    }
}
