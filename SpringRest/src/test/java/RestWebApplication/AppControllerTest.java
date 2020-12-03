package RestWebApplication;


import RestWebApplication.Controller.AppController;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppControllerTest {

    @LocalServerPort
    private int port;

    @InjectMocks
    private AppController appcontroller;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private AppController controller;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    /*@Test
    public void home() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
                String.class)).contains("Hello to my BookRepository");
    }*/

    @Test
    public void search() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/search?search=9",
                String.class)).contains("Guardians GALAXY 2");
    }

//    @Test
//    public void showall() throws Exception {
//        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/showAll",
//                String.class)).contains("Guardians GALAXY 2");
//    }

    @Test
    public void welcomeMeth(){
        String greeting = appcontroller.welcome();
        Assert.assertThat(greeting, containsString("home"));
    }

    @Test
    public void deleteMeth(){
        HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse mock = Mockito.mock(HttpServletResponse.class);

        String greeting = appcontroller.deleteBook(req, null);
        Assert.assertThat(greeting, containsString("home"));
    }

    @Test
    public void delete() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/deleteBook?delete=5",
                String.class)).contains("The book succesfully deleted");
    }


    @Test
    public void showAllMeth(){
        String greeting = appcontroller.showAll();
        Assert.assertThat(greeting, containsString("home"));
  }

    @Test
    public void add() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/addBook",
                String.class)).contains("The book succesfully added !");
    }

}
