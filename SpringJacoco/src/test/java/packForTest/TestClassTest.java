package packForTest;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestClassTest {

    TestClass ts = new TestClass();

    @Test
    public void testone(){
        String temp = ts.methodOne();
        assertEquals( "Four", temp);
    }


    @Test
    public void testTwo(){
        String temp2 = ts.methodThree();
        assertEquals( "Two", temp2);
    }



}
