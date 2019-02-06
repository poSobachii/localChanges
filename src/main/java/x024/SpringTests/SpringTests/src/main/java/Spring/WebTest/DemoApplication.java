package x024.SpringTests.SpringTests.src.main.java.Spring.WebTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("hello Spring Application");
	}

	// -- http://localhost:8080/     -> after running main app, youll see AnimalSimpleClassName World in browser
    // to run this main - need to compile new pom.xml file for maven as here is a version conflict
}

