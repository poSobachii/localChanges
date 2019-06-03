package parallelBeforeEachCallBackSTRING;

import org.junit.jupiter.api.Test;

import static parallelBeforeEachCallBackSTRING.FileWriterTT.printThree;

public class ParallelChromdedriverV4 extends MainParalleler {


    @Test
    public void tstOne() throws InterruptedException {

        tt.printThree();
        System.out.println("40");


    }

    @Test
    public void tstTwo() throws InterruptedException {

        tt.printThree();
        System.out.println("40");


    }

    @Test
    public void tstThree() throws InterruptedException {

        tt.printThree();
        System.out.println("40");


    }

    @Test
    public void tstFour() throws InterruptedException {

        tt.printThree();
        System.out.println("40");


    }

    @Test
    public void tstFive() throws InterruptedException {

        tt.printThree();
        System.out.println("40");


    }
}
