package tests;

import io.github.artsok.RepeatedIfExceptionsTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Repeat;

public class FailingTests {

    static int count = 1;

    @Test
    void testOne(){
        count++;
        int test1 = count%2;
        System.out.println("first test: " + count + " %: " + test1);
        Assert.assertEquals(0, test1);

    }

    @RepeatedIfExceptionsTest (repeats = 2)
    void testTwo(){
        count++;
        int test1 = count%3;
        System.out.println("second test: " + count + " %: " + test1);
        Assert.assertEquals(1, test1);
    }

    @Test
    void testThree(){
        count++;
        int test1 = count%2;
        System.out.println("thrid test: " + count + " %: " + test1);
    }

    @Test
    void testFour(){
        count++;
        int test1 = count%2;
        System.out.println("fourth test: " + count + " %: " + test1);
    }

    @RepeatedIfExceptionsTest (repeats = 6)
    void testFive(){
        Assert.assertEquals(10, 10);
    }


    @Test
    @Repeat(10)
    void testSix(){
        System.out.println("res="+ count);
        count++;

    }
}
