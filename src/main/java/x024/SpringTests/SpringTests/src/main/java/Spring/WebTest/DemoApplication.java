package x024.SpringTests.SpringTests.src.main.java.Spring.WebTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication
//@EnableAutoConfiguration
//@RequestMapping("animal")
public class DemoApplication {

//	@RequestMapping("/dog")    // with "" you edit adress. for now its -- http://localhost:8080/dog
//	String dog() {
//		System.out.println("each time u press F5 DOG browser, this shit is printed");
//		return "AnimalSimpleClassName DOG!";
//	}
//
//	@RequestMapping("/cat")
//	String cat() {
//		System.out.println("each time u press F5 in CAT browser , this shit is printed");
//		return "AnimalSimpleClassName CAT!";
//	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("hello Spring Application");
	}

	// -- http://localhost:8080/     -> after running main app, youll see AnimalSimpleClassName World in browser

}

