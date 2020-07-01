package jmeterApp.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MainController {

    int times = 0;

    @Autowired
    RequestService requestService;

    @GetMapping("/")
    @ResponseBody
    String home() {
        return "Hello application !!!";
    }

    @GetMapping("/post")
    @ResponseBody
    String postRequests() throws InterruptedException {
        requestService.invokeTestLoad();
        return "Hello post!";
    }

    @GetMapping("/endpoint")
    @ResponseBody
    String testEndpoint() {
        return "Hello endpoint !!";
    }

    @GetMapping("/v2/endpoint")
    @ResponseBody
    String testV2Endpoint() {
        System.out.println("v2 endpoint envoked times: " + times );
        times++;
        return "Hello endpoint V2!";
    }

    @PostMapping("/post/post")
    @ResponseBody
    String postPostRequests() throws InterruptedException {
        requestService.invokeTestLoad();
        return "Hello post-POST !";
    }


}
