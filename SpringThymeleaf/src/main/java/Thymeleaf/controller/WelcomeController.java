package Thymeleaf.controller;

import Thymeleaf.Bean.User;
import Thymeleaf.Service.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class WelcomeController {


    @Autowired
    News news;

    // inject via application.properties
    @Value("${welcome.message}")
    private String message;

    private List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

    private List<User> userList  = new ArrayList<User>() {{
        add(new User("Tom", "Jerry"));
        add(new User("Batman", "Robin"));
    }};


    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);
        model.addAttribute("print", news);

        return "welcome"; //view
    }

//    http://localhost:8080/hello?name=World
    @GetMapping("/hello")
    public String mainWithParam(
            @RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {

        model.addAttribute("message", name);

        return "welcome"; //view
    }

    @GetMapping("/addUser")
    public String sendForm(User user, Model model) {
        model.addAttribute("users", userList);
        return "addUser";
    }

    @PostMapping("/addUser")
    public String processForm(User user, Model model) {
        System.out.println("Name: " + user.getName());
        System.out.println("Occupation: " + user.getOccupation());
        userList.add(user);
        model.addAttribute("users", userList);
        return "addUser";
    }

}