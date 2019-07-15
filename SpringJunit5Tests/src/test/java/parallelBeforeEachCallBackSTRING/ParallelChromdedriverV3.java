package parallelBeforeEachCallBackSTRING;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static parallelBeforeEachCallBackSTRING.FileWriterTT.printTwo;

@Execution(ExecutionMode.CONCURRENT)
public class ParallelChromdedriverV3 extends MainParalleler {


    @Test
    public void tstOne() throws InterruptedException {

        tt.printTwo();
        System.out.println("30");


    }

    @Test
    public void tstTwo() throws InterruptedException {

        tt.printTwo();
        System.out.println("31");


    }

    @Test
    public void tstThree() throws InterruptedException {

        tt.printTwo();
        System.out.println("32");


    }

    @Test
    public void tstFour() throws InterruptedException {

        tt.printTwo();
        System.out.println("33");


    }

    @Test
    public void tstFive() throws InterruptedException {

        tt.printTwo();
        System.out.println("34");


    }
}
