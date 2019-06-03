package parallelBeforeEachCallBackResourceTest;

import org.junit.jupiter.api.Test;

public class ParallelChromdedriverV4 extends ResourceLocker {


    @Test
    public void tstOne() throws InterruptedException {
        for (int i = 0; i < 3 ; i++) {
            tt.printThree();
            System.out.println("Test THREE trigered v1");
            Thread.sleep(1000);
        }
    }

    @Test
    public void tstTwo() throws InterruptedException {
        for (int i = 0; i < 3 ; i++) {
            tt.printThree();
            System.out.println("Test THREE trigered v2");
            Thread.sleep(1000);
        }
    }

    @Test
    public void tstThree() throws InterruptedException {
        for (int i = 0; i < 3 ; i++) {
            tt.printThree();
            System.out.println("Test THREE trigered v3");
            Thread.sleep(1000);
        }
    }

}
