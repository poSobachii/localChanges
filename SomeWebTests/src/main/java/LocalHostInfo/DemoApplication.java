package LocalHostInfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("hello Spring Application");
    }

    // -- http://localhost:8080/     -> after running main app, youll see AnimalSimpleClassName World in browser

}