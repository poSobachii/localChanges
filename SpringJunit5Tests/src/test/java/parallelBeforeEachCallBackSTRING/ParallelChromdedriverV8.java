package parallelBeforeEachCallBackSTRING;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Execution(ExecutionMode.CONCURRENT)
public class ParallelChromdedriverV8 extends MainParalleler {


    @Test
    public void tstOne() throws InterruptedException {


        System.out.println("80");


    }

    @Test
    public void tstTwo() throws InterruptedException {


        System.out.println("81");


    }

    @Test
    public void tstThree() throws InterruptedException {


        System.out.println("82");


    }

    @Test
    public void tstFour() throws InterruptedException {


        System.out.println("83");


    }

    @Test
    public void tstFive() throws InterruptedException {


        System.out.println("84");


    }
}
