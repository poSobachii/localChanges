package parallelBeforeEachCallBackSTRING;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static parallelBeforeEachCallBackSTRING.FileWriterTT.printThree;

@Execution(ExecutionMode.CONCURRENT)
public class ParallelChromdedriverV4 extends MainParalleler {


    @Test
    public void tstOne() throws InterruptedException {

        tt.printThree();
        System.out.println("40");


    }

    @Test
    public void tstTwo() throws InterruptedException {

        tt.printThree();
        System.out.println("41");


    }

    @Test
    public void tstThree() throws InterruptedException {

        tt.printThree();
        System.out.println("42");


    }

    @Test
    public void tstFour() throws InterruptedException {

        tt.printThree();
        System.out.println("43");


    }

    @Test
    public void tstFive() throws InterruptedException {

        tt.printThree();
        System.out.println("44");


    }
}
