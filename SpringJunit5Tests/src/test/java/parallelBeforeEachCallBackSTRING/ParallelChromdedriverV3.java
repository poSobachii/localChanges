package parallelBeforeEachCallBackSTRING;

import org.junit.jupiter.api.Test;

import static parallelBeforeEachCallBackSTRING.FileWriterTT.printTwo;

public class ParallelChromdedriverV3 extends MainParalleler {


    @Test
    public void tstOne() throws InterruptedException {

        tt.printTwo();
        System.out.println("30");


    }

    @Test
    public void tstTwo() throws InterruptedException {

        tt.printTwo();
        System.out.println("30");


    }

    @Test
    public void tstThree() throws InterruptedException {

        tt.printTwo();
        System.out.println("30");


    }

    @Test
    public void tstFour() throws InterruptedException {

        tt.printTwo();
        System.out.println("30");


    }

    @Test
    public void tstFive() throws InterruptedException {

        tt.printTwo();
        System.out.println("30");


    }
}
