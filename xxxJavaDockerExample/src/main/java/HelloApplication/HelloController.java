package HelloApplication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

@Controller
@RequestMapping("/dog")
public class HelloController {

    @Value("{dog.message}")
    private String note;


    @GetMapping("/barking")
    public String getPage(Model model) {
        model.addAttribute("dogMeow", note);
        model.addAttribute("dogBark", new Barking());
        return "dogs";
    }

    @PostMapping("/barking")
    public String printPage(Model model, @ModelAttribute Barking bark) {
        model.addAttribute("dogMeow", bark.getBark());
        model.addAttribute("dogBark", new Barking());
        return "dogs";
    }

    @GetMapping("/{yo}")
    public String getPage2(@PathVariable("yo") String temp, Model model) {
        model.addAttribute("dogMeow", temp);
        model.addAttribute("dogBark", new Barking());
        return "dogs";
    }

    @GetMapping("/defDog")
    public String getPage3(@RequestParam(value = "date", required = false) String date, Model model) {
        model.addAttribute("dogMeow", date);
        model.addAttribute("dogBark", new Barking());
        return "dogs";
    }

    @GetMapping("/blindDog")
    public String getPage4(@QueryParam("date") String date, Model model) {
        model.addAttribute("dogMeow", date);
        model.addAttribute("dogBark", new Barking());
        return "dogs";
    }

    @GetMapping("/redirect")
    public ResponseEntity<Object> getRedirect( ) throws URISyntaxException {
        URI uri = new URI("http://www.google.com");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }


}