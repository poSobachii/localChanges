package ymlTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private GlobalProperties globalProperties;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }

    @Override
    public void run(String... args) {
        String test = globalProperties.getEmail();
        String tests = globalProperties.getMessage();
        String testoss = globalProperties.getSomeWrongMessage();
        int test2 = globalProperties.getThreadPool();
        String email2 = globalProperties.getEmail2();
        String[] array0 = {"string1", "string2"};
        String[] array = globalProperties.getArrayOfString();
        List<String> listofString = globalProperties.getListOfString();
        System.out.println("email: " + test);
        System.out.println("number: " + test2);
        System.out.println("message: " + tests);
        System.out.println("must be wrong message: " + testoss);
        System.out.println("this is used without @value: " + email2);
        System.out.println("Array is 0 and have following: " + array[0] + " 2nd argument: " + array[1] + " size:" + array.length);
        System.out.println("List of string have the following: " + listofString.get(0) + " 2nd argument: " + listofString.get(0) + " size:" + listofString.size());
    }
}
