package parallelBeforeEachCallBackResourceTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.ResourceLock;

import static org.junit.jupiter.api.parallel.ResourceAccessMode.READ_WRITE;

@ExtendWith(BeforeTests.class)
public class ResourceLocker {

    private static boolean started = false;
    static FileWriterTT tt = new FileWriterTT();


//    @BeforeAll
//    @ResourceLock(value = "System Properties", mode = READ_WRITE)
//    public static void resoureceTest() throws InterruptedException {
//        System.out.println("STARTING COUNTDOWN !");
//        for (int i = 0; i < 5; i++) {
//            System.out.println("THE SYSTEM IS BUSY FOR: " + (5-i));
//            tt.printFour(i);
//            Thread.sleep(1000);
//        }
//    }

    @BeforeEach
    void before() {
        System.out.println("test started --> ");
    }


    @AfterEach
    void waitin() throws InterruptedException {
        System.out.println("<--test ended ");
    }

}
