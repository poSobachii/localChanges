package u001Usefull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadSleepCheck {

    public static void main(String[] args) {

        while (true) {
            long duration = System.currentTimeMillis();
            DateFormat simple = new SimpleDateFormat("HH:mm:ss:SSS");
            Date result = new Date(duration);
            System.out.println("Current time: " + simple.format(result));
            try {
//               Thread.sleep(100);
                for (int i = 0; i < 550 ; i++) {
                    Thread.sleep(100);
                }
            } catch (InterruptedException ex) {
                System.out.println("error: " + ex);
            }
        }
    }
}






