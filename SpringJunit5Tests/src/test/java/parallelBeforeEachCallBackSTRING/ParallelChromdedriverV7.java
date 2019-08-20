package parallelBeforeEachCallBackSTRING;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Execution(ExecutionMode.CONCURRENT)
public class ParallelChromdedriverV7 extends MainParalleler {


    @Test
    public void tstOne() throws InterruptedException {


        System.out.println("70");


    }

    @Test
    public void tstTwo() throws InterruptedException {


        System.out.println("71");


    }

    @Test
    public void tstThree() throws InterruptedException {


        System.out.println("72");


    }

    @Test
    public void tstFour() throws InterruptedException {


        System.out.println("73");


    }

    @Test
    public void tstFive() throws InterruptedException {


        System.out.println("74");


    }
}