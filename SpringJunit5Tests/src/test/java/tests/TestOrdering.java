package tests;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class TestOrdering {

    static int count = 1;

    @Test
    @Order(7)
    void testOne(){
        count++;
        System.out.println("first test: " + count);

    }

    @Test
    @Order(2)
    void testTwo(){
        count++;
        System.out.println("second test: " + count);
    }

    @Test
    @Order(3)
    void testThree(){
        count++;
        System.out.println("thrid test: " + count);
    }

    @Test
    @Order(4)
    void testFour(){
        count++;
        System.out.println("fourth test: " + count);
    }

    @Test
    @Order(5)
    void testFive(){
        count++;
        System.out.println("fifth test: " + count);
    }

    @RepeatedTest(value = 5, name = RepeatedTest.LONG_DISPLAY_NAME)
    @Order(6)
    void testSix(){
        count++;
        System.out.println("SIXTH test: " + count);
    }
}
