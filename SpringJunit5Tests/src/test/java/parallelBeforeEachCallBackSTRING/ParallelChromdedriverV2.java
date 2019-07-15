package parallelBeforeEachCallBackSTRING;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static parallelBeforeEachCallBackSTRING.FileWriterTT.printOne;

@Execution(ExecutionMode.CONCURRENT)
public class ParallelChromdedriverV2 extends MainParalleler {


    @Test
    public void tstOne() throws InterruptedException {

        tt.printOne();
        System.out.println("20");


    }

    @Test
    public void tstTwo() throws InterruptedException {

        tt.printOne();
        System.out.println("21");


    }

    @Test
    public void tstThree() throws InterruptedException {

        tt.printOne();
        System.out.println("22");


    }

    @Test
    public void tstFour() throws InterruptedException {

        tt.printOne();
        System.out.println("23");


    }

    @Test
    public void tstFive() throws InterruptedException {

        tt.printOne();
        System.out.println("24");


    }
}
