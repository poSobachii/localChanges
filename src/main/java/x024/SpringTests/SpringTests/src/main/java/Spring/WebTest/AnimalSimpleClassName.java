package x024.SpringTests.SpringTests.src.main.java.Spring.WebTest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("animal")    //adds string to adress --  http://localhost:8080/animal
public class AnimalSimpleClassName {

	@RequestMapping("/dog")    // with "" you edit adress. for now its -- http://localhost:8080/dog
	String dog() {
		System.out.println("each time u press F5 DOG browser, this shit is printed");
		return "AnimalSimpleClassName DOG!";
	}

	@RequestMapping("/cat")
	String cat() {
		System.out.println("each time u press F5 in CAT browser , this shit is printed");
		return "AnimalSimpleClassName CAT!";
	}

}