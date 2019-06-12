package HelloApplication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dog")
public class HelloController {

    @Value("${dog.message}")
    private String note;


    @GetMapping("")
    public String getPage(Model model) {
        model.addAttribute("dogMeow", note);
        model.addAttribute("dogBark", new Barking());
        return "dogs";
    }

    @PostMapping("")
    public String printPage(Model model, @ModelAttribute Barking bark){
        model.addAttribute("dogMeow", bark.getBark() );
        model.addAttribute("dogBark", new Barking());
        return "dogs";
    }
}