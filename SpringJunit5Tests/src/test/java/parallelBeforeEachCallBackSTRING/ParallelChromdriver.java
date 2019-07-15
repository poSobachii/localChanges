package parallelBeforeEachCallBackSTRING;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Execution(ExecutionMode.CONCURRENT)
public class ParallelChromdriver extends MainParalleler {


    @Test
    public void tstOne() throws InterruptedException {

        sleepin();
        System.out.println("10");


    }

    @Test
    public void tstTwo() throws InterruptedException {

        sleepin();
        System.out.println("11");


    }

    @Test
    public void tstThree() throws InterruptedException {

        sleepin();
        System.out.println("12");


    }

    @Test
    public void tstFour() throws InterruptedException {

        sleepin();
        System.out.println("13");


    }

    @Test
    public void tstFive() throws InterruptedException {

        sleepin();
        System.out.println("14");


    }

    @Test
    public void tstSix() throws InterruptedException {

        sleepin();
        System.out.println("15");


    }

    @Test
    public void tstSeven() throws InterruptedException {

        sleepin();
        System.out.println("16");


    }

    @Test
    public void tstEight() throws InterruptedException {

        sleepin();
        System.out.println("17");


    }

    @Test
    public void tstNine() throws InterruptedException {

        sleepin();
        System.out.println("18");


    }

    @Test
    public void tstTen() throws InterruptedException {

        sleepin();
        System.out.println("19");


    }

    @Test
    public void tstEleven() throws InterruptedException {

        sleepin();
        System.out.println("9");


    }

    @Test
    public void tstTwelve() throws InterruptedException {

        sleepin();
        System.out.println("8");


    }

    @Test
    public void tstThirteen() throws InterruptedException {

        sleepin();
        System.out.println("7");


    }

    @Test
    public void tstFourteen() throws InterruptedException {

        sleepin();
        System.out.println("6");


    }

    @Test
    public void tstFifteen() throws InterruptedException {

        sleepin();
        System.out.println("5");


    }

    @Test
    public void tstSixteen() throws InterruptedException {

        sleepin();
        System.out.println("4");


    }

    @Test
    public void tstSeventeen() throws InterruptedException {

        sleepin();
        System.out.println("3");


    }

    @Test
    public void tstEighteen() throws InterruptedException {

        sleepin();
        System.out.println("2");


    }

    @Test
    public void tstNineteen() throws InterruptedException {

        sleepin();
        System.out.println("1");


    }

    @Test
    public void tstTenteen() throws InterruptedException {

        sleepin();
        System.out.println("00");


    }

}


