package parallelBeforeEachCallBackSTRING;

import org.junit.jupiter.api.Test;

import static parallelBeforeEachCallBackSTRING.FileWriterTT.printOne;

public class ParallelChromdedriverV2 extends MainParalleler {


    @Test
    public void tstOne() throws InterruptedException {

        tt.printOne();
        System.out.println("20");


    }

    @Test
    public void tstTwo() throws InterruptedException {

        tt.printOne();
        System.out.println("20");


    }

    @Test
    public void tstThree() throws InterruptedException {

        tt.printOne();
        System.out.println("20");


    }

    @Test
    public void tstFour() throws InterruptedException {

        tt.printOne();
        System.out.println("20");


    }

    @Test
    public void tstFive() throws InterruptedException {

        tt.printOne();
        System.out.println("20");


    }
}
