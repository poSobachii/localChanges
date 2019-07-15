package parallelBeforeEachCallBackSTRING;

import org.junit.jupiter.api.parallel.ResourceLock;

import static org.junit.jupiter.api.parallel.ResourceAccessMode.READ;
import static org.junit.jupiter.api.parallel.ResourceAccessMode.READ_WRITE;

//@ResourceLock(value = "yo", mode = READ)
public class Locker extends Thread {

    public void sleepin() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            System.out.println("THE SYSTEM IS BUSY FOR LOCKER: " + (5 - i));
            Thread.sleep(1000);
        }
    }

    @Override
    public void run() {
        synchronized(this) {
            for (int i = 0; i < 5; i++) {
                System.out.println("THE SYSTEM IS BUSY FOR LOCKER: " + (5 - i));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } notify();
        }
    }
}
