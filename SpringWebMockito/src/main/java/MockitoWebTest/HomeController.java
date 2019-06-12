package MockitoWebTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

@Controller
public class HomeController {

    @Inject
    ObjectClass obj;

    @RequestMapping("/")
    public @ResponseBody
    String greeting() {
        return "Hello World";
    }

    @RequestMapping("/yo")
    @ResponseBody
    public ObjectClass satan(){
        return obj;
    }
}
