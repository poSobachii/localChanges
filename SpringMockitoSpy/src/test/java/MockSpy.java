import emppack.SpyExamples;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

public class MockSpy {


    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);

    }
    @Mock
    private List<String> mockList;
    @Spy
    private List<String> spyList = new ArrayList();
    @Mock
    private SpyExamples spyExamples;
    @Spy
    private SpyExamples spyExamples2;

    @Test
    public void testMockList() {
        //by default, calling the methods of mock object will do nothing
        mockList.add("test");
        assertNull(mockList.get(0));
    }

    @Test
    public void testSpyList() {
        //spy object will call the real method when not stub
        spyList.add("test");
        assertEquals("test", spyList.get(0));
    }

    @Test
    public void testMockWithStub() {
        //try stubbing a method
        String expected = "Mock 100";
        when(mockList.get(100)).thenReturn(expected);
        assertEquals(expected, mockList.get(100));
    }

    @Test
    public void testSpyWithStub() {
        //stubbing a spy method will result the same as the mock object
        String expected = "Spy 100";
        //take note of using doReturn instead of when
        doReturn(expected).when(spyList).get(100);
        assertEquals(expected, spyList.get(100));
    }

    @Test
    public void testMySpy(){
        String temp = spyExamples.setup();
        System.out.println("Res= " + temp);
    }

    @Test
    public void testMySpy2(){
        String temp = spyExamples2.setup();
        System.out.println("Res1= " + temp);

        doReturn("dog").when(spyExamples2).setup();
        String temp2 = spyExamples2.setup();
        System.out.println("Res2= " + temp2);
    }
}
