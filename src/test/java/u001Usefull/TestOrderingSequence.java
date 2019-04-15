package u001Usefull;

import com.googlecode.junittoolbox.ParallelRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

@RunWith(ParallelRunner.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@Execution(ExecutionMode.CONCURRENT)
public class TestOrderingSequence {

    private int globalInt;


    void setNumber(int number){
        this.globalInt = number;
        System.out.println("setNumber method in with: " + number);

    }

    int getNumber(){
        System.out.println("getNumber method out with: " + globalInt);
        return globalInt;
    }

//    @BeforeEach
//    void init(){
//        System.out.println("test triggered");
//    }
//
//    @AfterEach
//    void ended(){
//        System.out.println("test ended");
//    }

    @Before
    public void init(){
        System.out.println("->");
    }

    @After
    public void ended(){
        System.out.println("<-");
    }

    @Test
    public void stringAOne(){
        int temp = 1111;
        System.out.println(" #1 triggered: " + temp);
        System.out.println(" #1 current global: " + globalInt);
        setNumber(temp);
        System.out.println(" #1.1 current global: " + globalInt);
        int temp1 = getNumber();
        System.out.println(" 1 test finnaly done with number :" + temp1);
    }

    @Test
    public void stringBTwo(){
        int temp = 2222;
        System.out.println(" #2 triggered: " + temp);
        System.out.println(" #2 current global: " + globalInt);
        setNumber(temp);
        System.out.println(" #2.2 current global: " + globalInt);
        int temp2 = getNumber();
        System.out.println(" 2 test finnaly done with number :" + temp2);
    }

    @Test
    public void stringCThree(){
        int temp = 3333;
        System.out.println(" #3 triggered: " + temp);
        System.out.println(" #3 current global: " + globalInt);
        setNumber(temp);
        System.out.println(" #3.3 current global: " + globalInt);
        int temp3 = getNumber();
        System.out.println(" 3 test finnaly done with number :" + temp3);
    }

    @Test
    public void stringDFour(){
        int temp = 4444;
        System.out.println(" #4 triggered: " + temp);
        System.out.println(" #4 current global: " + globalInt);
        setNumber(temp);
        System.out.println(" #4.4 current global: " + globalInt);
        int temp4 = getNumber();
        System.out.println(" 4 test finnaly done with number :" + temp4);
    }

    @Test
    public void stringEFive(){
        int temp = 5555;
        System.out.println(" #5 triggered: " + temp);
        System.out.println(" #5 current global: " + globalInt);
        setNumber(temp);
        System.out.println(" #5.5 current global: " + globalInt);
        int temp5 = getNumber();
        System.out.println(" 5 test finnaly done with number :" + temp5);
    }



    //    @Test
//    void stringAOne(){
//        int temp = 1;
//        System.out.println(" 1 test triggered with number: " + temp);
//        setNumber(temp);
//        System.out.println(" 1 test triggered");
//    }
//
//    @Test
//    void stringBTwo(){
//        System.out.println(" 2 test triggered");
//    }
//
//    @Test
//    void stringCThree(){
//        System.out.println(" 3 test triggered");
//    }
//
//    @Test
//    void stringDFour(){
//        System.out.println(" 4 test triggered");
//    }
//
//    @Test
//    void stringEFive(){
//        System.out.println(" 5 test triggered");
//    }

}
