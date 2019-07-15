package parallelBeforeEachCallBackSTRING;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Execution(ExecutionMode.CONCURRENT)
public class ParallelChromdedriverV5 extends MainParalleler {


    @Test
    public void tstOne() throws InterruptedException {

        System.out.println("50");

    }

    @Test
    public void tstTwo() throws InterruptedException {


        System.out.println("51");




    }

    @Test
    public void tstThree() throws InterruptedException {


        System.out.println("52");




    }

    @Test
    public void tstFour() throws InterruptedException {


        System.out.println("53");




    }

    @Test
    public void tstFive() throws InterruptedException {


        System.out.println("54");




    }
}
