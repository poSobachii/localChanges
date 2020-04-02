package a112_rest_spring.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home2")
public class anotherRestController {

    @GetMapping("/param")
    String printString(@RequestParam (value = "name", required =  false) String input) {
        System.out.println("Request worked with input: " + input);
        return "Hello " + input;
    }

//    http://localhost:8080/home2/params?name=John&surname=Wick&age=45
    @GetMapping("/params")
    String printStringv4(@RequestParam (value = "name", required =  false) String name,
                         @RequestParam(value = "surname") String surname, @RequestParam(value = "age") int age) {
        System.out.println("Request worked with inputs: " + name  + " " + surname + " " + age);
        return "Hello "  + name  + " " + surname + " " + age;
    }

    @GetMapping("/defaultparam")
    String printStringv2(@RequestParam (value = "name", defaultValue = "world") String input) {
        System.out.println("Request worked with input: " + input);
        return "Hello " + input;
    }

    @GetMapping("/{input}/static")
    String printStringv3(@PathVariable String input) {
        System.out.println("Request PATH worked with input: " + input);
        return "Hello " + input;
    }

    @GetMapping("/{input}/pathstillgoing")
    String printStringv5(@PathVariable String input) {
        System.out.println("Request pathstillgoing worked with input: " + input);
        return "Hello " + input;
    }
}
