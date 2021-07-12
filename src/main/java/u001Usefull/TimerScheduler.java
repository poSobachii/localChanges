package u001Usefull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerScheduler {

    public static void main(String[] args) {

//                while (true) {
//            long duration = System.currentTimeMillis();
//            Thread t = new Thread();
//            DateFormat simple = new SimpleDateFormat("HH:mm:ss:SSS");
//            Date result = new Date(duration);
//            System.out.println("Current time: " + simple.format(result));
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException ex) {
//                System.out.println("error: " + ex);
//            }
//
////            Thread.sleep(100);
////            Thread.sleep(100);
////            Thread.sleep(100);
////            Thread.sleep(100);
////            Thread.sleep(100);
////            Thread.sleep(100);
////            Thread.sleep(100);
////            Thread.sleep(100);
////            Thread.sleep(100);
//
//        }
//
//    }


        java.util.Timer timer = new java.util.Timer();
        timer.schedule(new SayHello(), 0, 5000);
    }
}

    class SayHello extends TimerTask {
        public void run() {
            System.out.println("Hello World!");
        }
    }





