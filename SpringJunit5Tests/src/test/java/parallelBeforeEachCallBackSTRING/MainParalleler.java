package parallelBeforeEachCallBackSTRING;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceLock;


import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.parallel.ResourceAccessMode.READ_WRITE;

//@ExtendWith(BeforeTestsString.class)
@Execution(ExecutionMode.CONCURRENT)
//@ResourceLock(value = "System Properties", mode = READ_WRITE)
public class MainParalleler {

    static int count = 666;
    private static boolean started = false;
    static FileWriterTT tt = new FileWriterTT();
    static Locker locker = new Locker();

//    @BeforeAll
//    public static void beforeALl() {
//        System.out.println("BEFORE INITIALISATION  100");
//        if (!started) {
//            System.out.println("STARTED TRIGGERED  1000");
//            started = true;
//            System.out.println("BEFORE NUMBER OF COUNT " + count);
//            count++;
//        }
//    }

    @ResourceLock(value = "System Properties", mode = READ_WRITE)
    @BeforeAll
    public static void resoureceTest() throws InterruptedException {

        Locker b = new Locker();
        b.start();

        synchronized(b){
            try{
                System.out.println("Waiting for b to complete...");
                b.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("Locker done ?");
        }
    }

    @AfterAll
    public static void afterALl() {
        System.out.println("THE FINAL COUNT IS: " + count);
    }

    @BeforeEach
    void before() {
        System.out.println("test started --> ");
    }


    @AfterEach
    void waitin() throws InterruptedException {
        System.out.println("<--test ended ");
    }

    void sleepin() throws InterruptedException {
        Thread.sleep(5000);
    }
}
