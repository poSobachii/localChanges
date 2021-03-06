package u001Usefull;

import com.googlecode.junittoolbox.ParallelRunner;
import org.junit.After;
import org.junit.Before;
//import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//@RunWith(ParallelRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@Execution(ExecutionMode.CONCURRENT)
public class TestOrderingSequence {


    private int globalInt;
    private long duration;
    static TestOrderingSequence  yo = new TestOrderingSequence ();

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getDuration() {
        return duration;
    }

    void setNumber(int number){
        this.globalInt = number;
        System.out.println("setNumber method in with: " + number);

    }

    int getNumber(){
        System.out.println("getNumber method out with: " + globalInt);
        return globalInt;
    }

    @BeforeAll
    static void loadtime(){
        yo.setDuration(System.currentTimeMillis());
    }

    @AfterAll
    static void savetime(){
        long time = System.currentTimeMillis();
        long result = time - yo.getDuration();
        DateFormat simple = new SimpleDateFormat("mm:ss:SSS");
        Date print = new Date(result);
        System.out.println("Execution time Minutes/Seconds/Miliseconds: " +  simple.format(print));
    }

    @BeforeEach
    void init(){
        System.out.println("->");
    }

    @AfterEach
    void ended(){
        System.out.println("<-");
    }

    public void sleep() throws InterruptedException {
        Thread.sleep(1000);
    }

//    @Before
//    public void init(){
//        System.out.println("->");
//    }
//
//    @After
//    public void ended(){
//        System.out.println("<-");
//    }

    @Test
    public void stringAOne() throws InterruptedException {
        int temp = 1111;
        System.out.println(" #1 triggered: " + temp);
        System.out.println(" #1 current global: " + globalInt);
        setNumber(temp);
        sleep();
        System.out.println(" #1.1 current global: " + globalInt);
        int temp1 = getNumber();
        System.out.println(" 1 test finnaly done with number :" + temp1);
    }

    @Test
    @Disabled
    public void stringBTwo() throws InterruptedException {
        int temp = 2222;
        System.out.println(" #2 triggered: " + temp);
        System.out.println(" #2 current global: " + globalInt);
        setNumber(temp);
        sleep();
        System.out.println(" #2.2 current global: " + globalInt);
        int temp2 = getNumber();
        System.out.println(" 2 test finnaly done with number :" + temp2);
    }

    @Test
    public void stringCThree() throws InterruptedException {
        int temp = 3333;
        System.out.println(" #3 triggered: " + temp);
        System.out.println(" #3 current global: " + globalInt);
        setNumber(temp);
        sleep();
        System.out.println(" #3.3 current global: " + globalInt);
        int temp3 = getNumber();
        System.out.println(" 3 test finnaly done with number :" + temp3);
    }

    @Test
    public void stringDFour() throws InterruptedException {
        int temp = 4444;
        System.out.println(" #4 triggered: " + temp);
        System.out.println(" #4 current global: " + globalInt);
        setNumber(temp);
        sleep();
        System.out.println(" #4.4 current global: " + globalInt);
        int temp4 = getNumber();
        System.out.println(" 4 test finnaly done with number :" + temp4);
    }

    @Test
    public void stringEFive() throws InterruptedException {
        int temp = 5555;
        System.out.println(" #5 triggered: " + temp);
        System.out.println(" #5 current global: " + globalInt);
        setNumber(temp);
        sleep();
        System.out.println(" #5.5 current global: " + globalInt);
        int temp5 = getNumber();
        System.out.println(" 5 test finnaly done with number :" + temp5);
    }

}
