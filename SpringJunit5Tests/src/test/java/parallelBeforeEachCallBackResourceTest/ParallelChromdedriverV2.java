package parallelBeforeEachCallBackResourceTest;

import org.junit.jupiter.api.Test;

import javax.xml.transform.Source;

public class ParallelChromdedriverV2 extends ResourceLocker {


    @Test
    public void tstOne() throws InterruptedException {
        for (int i = 0; i < 3 ; i++) {
            tt.printOne();
            System.out.println("Test ONE trigered v1");
            Thread.sleep(1000);
        }
    }

    @Test
    public void tstTwo() throws InterruptedException {
        for (int i = 0; i < 3 ; i++) {
            tt.printOne();
            System.out.println("Test ONE trigered v2");
            Thread.sleep(1000);
        }
    }

    @Test
    public void tstThree() throws InterruptedException {
        for (int i = 0; i < 3 ; i++) {
            tt.printOne();
            System.out.println("Test ONE trigered v3");
            Thread.sleep(1000);
        }
    }

}
