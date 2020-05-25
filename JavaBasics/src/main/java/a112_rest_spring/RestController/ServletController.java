package a112_rest_spring.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
@RequestMapping("/servlet")
public class ServletController {

    @GetMapping("/home")
    String methodv1(@RequestHeader(value = "Accept-Language", required = false) String input,
                @RequestHeader(value = "this-is-own-header") String input2){
        return "hello " + input;
    }

    @GetMapping("/servlet")
    String methodv2(HttpServletRequest request, HttpSession session) throws MalformedURLException {
        System.out.println(request.getRequestURI());
        System.out.println(request.getQueryString());
        System.out.println(request.getHeader("this-is-own-header"));

        URL url = new URL (request.getRequestURL().toString());
        System.out.println(url.getHost());
        System.out.println(url.getPath());
        return "done";
    }
    @GetMapping("/response")
    String methodv3(HttpServletResponse response){
        response.addHeader("this is reponse header", "value1");
        return "done";
    }

    @GetMapping("/entity")
    ResponseEntity returnMeRent(){
        System.out.println("entity worked");
        return ResponseEntity.status(403).body(1000);
    }

    @GetMapping("/exception")
    String returnException(){
        SomeObject obj = new SomeObject();
        return obj.doSomething(true);
    }




}
