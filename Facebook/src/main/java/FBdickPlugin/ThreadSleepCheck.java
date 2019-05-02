package FBdickPlugin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadSleepCheck {

    public static void main(String[] args) {

        while (true) {
            long duration = System.currentTimeMillis();
            DateFormat simple = new SimpleDateFormat("HH:mm:ss:SSS");
            Date result = new Date(duration);
            System.out.println("Current time: " + simple.format(result));
            try {
                for (int i = 0; i < 550 ; i++) {
                    Thread.sleep(100);
                }
            } catch (InterruptedException ex) {
                System.out.println("error: " + ex);
            }
        }
    }
}






