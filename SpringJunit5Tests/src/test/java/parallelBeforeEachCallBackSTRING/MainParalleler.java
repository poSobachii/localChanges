package parallelBeforeEachCallBackSTRING;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.ResourceLock;


import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.parallel.ResourceAccessMode.READ_WRITE;

//@ExtendWith(BeforeTestsString.class)
@ResourceLock(value = "System Properties", mode = READ_WRITE)
public class MainParalleler {

    static int count = 666;
    private static boolean started = false;
    static FileWriterTT tt = new FileWriterTT();


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

    @BeforeAll
    public static void resoureceTest() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            System.out.println("THE SYSTEM IS BUSY FOR: " + (5-i));
            Thread.sleep(1000);
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

}
