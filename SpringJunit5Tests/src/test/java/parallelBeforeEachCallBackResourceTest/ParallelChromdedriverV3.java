package parallelBeforeEachCallBackResourceTest;

import org.junit.jupiter.api.Test;

public class ParallelChromdedriverV3 extends ResourceLocker {


    @Test
    public void tstOne() throws InterruptedException {
        for (int i = 0; i < 3 ; i++) {
            tt.printTwo();
            System.out.println("Test TWO trigered v1");
            Thread.sleep(1000);
        }
    }

    @Test
    public void tstTwo() throws InterruptedException {
        for (int i = 0; i < 3 ; i++) {
            tt.printTwo();
            System.out.println("Test TWO trigered v2");
            Thread.sleep(1000);
        }
    }

    @Test
    public void tstThree() throws InterruptedException {
        for (int i = 0; i < 3 ; i++) {
            tt.printTwo();
            System.out.println("Test TWO trigered v3");
            Thread.sleep(1000);
        }
    }


}
