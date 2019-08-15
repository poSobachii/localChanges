package JPAExample;

import JPAExample.databaseS.Entities.User;
import JPAExample.databaseS.Repos.UserReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/")
public class MainController {

    @Autowired
    UserReposity userReposity;


    @GetMapping
    public List<User> home(){
        System.out.println(" /Home invoked !");
        return userReposity.findByuserAdress("Madrid street");
    }

    @GetMapping("/v2")
    public List<?> home2(){
        return userReposity.somemethod("Alek");
    }
}
