package LocalHostInfo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Launch {

    public static void main(String[] args) {
        SpringApplication.run(Launch.class, args);
        System.out.println("Uploading Spring Application");
    }

    // -- http://localhost:8080/     -> after running main app, youll see AnimalSimpleClassName World in browser

}
