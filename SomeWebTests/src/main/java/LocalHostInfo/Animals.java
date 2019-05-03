package LocalHostInfo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController       // depends what retunr will be be // @Controller - will return page.
@RequestMapping ("animal")    //adds string to adress --  http://localhost:8080/animal
public class Animals {

    @RequestMapping("/dog")    // with "" you edit adress. for now its -- http://localhost:8080/animal/dog
    public String dog() {
        System.out.println("each time u press F5 DOG browser, this shit is printed");
        return "AnimalSimpleClassName DOG!";
    }

    @RequestMapping("/cat")
    public String cat() {
        System.out.println("each time u press F5 in CAT browser , this shit is printed");
        return "AnimalSimpleClassName CAT!";

    }

}