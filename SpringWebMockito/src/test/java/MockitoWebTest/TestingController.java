package MockitoWebTest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class TestingController {


    ConfigurationClass cfgClass;

    @Inject
    ObjectClass obj;

    @Mock
    private HomeController grtcontroller;

    @Test
    public void firsttest() throws JsonProcessingException {
        obj = grtcontroller.satan();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String response = ow.writeValueAsString(obj);
        assertThat(response, containsString("keys"));
    }

}
