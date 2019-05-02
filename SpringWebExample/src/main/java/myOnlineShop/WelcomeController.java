package myOnlineShop;


import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class WelcomeController {

    // inject via application.properties
    @Value("${welcome.message:test2}")
    private String message;

    @Value("${welcome.messageT:test2}")
    private String messageT;

    @Value("${index.messageT:yo}")
    private String indexmsg;




    @RequestMapping(value = {"/" , "welcome"})
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        model.put("messageT", this.messageT);
        return "welcome";
    }

    @RequestMapping("/index")
    public String index(Map<String, Object> model) {
        model.put("indexingmsg", this.indexmsg);
        System.out.println("Index requested");
        return "index";
    }

    @RequestMapping(value="/myservlet", method = RequestMethod.GET)
    public String myservlet(HttpServletRequest request, HttpServletResponse response) {
        DataStorage DS = new DataStorage();
        String temp = request.getParameter("bloha");
        System.out.println(temp);
        if (!temp.isEmpty()) {
            DS.setTemp(temp);
            System.out.println(temp);
        }
        System.out.println("servlet in controller requested");
        return "index";
    }

    @RequestMapping("/jquery")
    public String loginMessage()
    {
        return "jquery";
    }

    @RequestMapping("/jsbutton")
    public String javascriptTest()
    {
        return "jsbutton";
    }

    @RequestMapping("/jsFromJava")
    public String javascriptJavaTest()
    {
        TempClass.invokeJS();
        return "JSfromJava";
    }

    @RequestMapping(value = "/myTest", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public String testingMethod (HttpServletRequest request, HttpServletResponse response)
    {
        String temp = request.getParameter("methodCheck");
        System.out.println(temp);
        System.out.println("myTest worked");
        return "index";
    }

}
