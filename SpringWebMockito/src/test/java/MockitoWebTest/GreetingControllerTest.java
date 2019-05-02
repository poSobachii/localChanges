package MockitoWebTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GreetingControllerTest {

    @InjectMocks
    private GreetingController grtcontroller;

    @Mock
    private GreetingService grtservice;

    @Test
    public void test(){
        when(grtservice.greet()).thenReturn("Hello");

        String greeting = grtcontroller.greeting();
        assertThat(greeting, is("Hello"));

    }


}
