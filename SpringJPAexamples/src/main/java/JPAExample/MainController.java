package JPAExample;

import JPAExample.databaseS.Entities.User;
import JPAExample.databaseS.Exceptions.ExceptionHandling;
import JPAExample.databaseS.Exceptions.OrdinaryException;
import JPAExample.databaseS.Repos.UserReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping( "/")
public class MainController {

    @Autowired
    UserReposity userReposity;
    @Inject
    ExceptionHandling exceptionHandler;


    @GetMapping
    public List<User> home(){
        exceptionHandler.printStatus();
        System.out.println(" /Home invoked !");
        return userReposity.findByuserAdress("Madrid street");
    }

    @GetMapping("/v3")
    public List<User> home3(){
        return userReposity.findBysurname("Hujatriza");
    }

    @GetMapping("/v4")
    public String home4(){
        System.out.println("fist string " + userReposity.somemethodv2("Crhis"));
        System.out.println("second string " + userReposity.somemethodv2("Crhisss"));
        return userReposity.somemethodv2("Crhis");
    }

    @GetMapping("/v2")
    public List<?> home2(){
        return userReposity.somemethod("Crhis");
    }

    @GetMapping("/v5")
    public String home5(){
        String temp1 = exceptionHandler.getRuntime(0);
        System.out.println("result is " + temp1);
        return temp1;
    }

    @GetMapping("/v6")
    public String home6() {
        String temp1 = "temporary";
        try {
            temp1 = exceptionHandler.getOrdinaryException(0);
        } catch (OrdinaryException e) {
            System.out.println("we went into catch method");
            e.printStackTrace();
        }
        System.out.println("result is " + temp1);
        return temp1;
    }
}
