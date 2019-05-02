package jquery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {
	
	@RequestMapping(path="/", method=RequestMethod.GET)

	public String goHome(){
		TimeChecker.TimeCheck("home map requested");
		return "index";
	}

	@RequestMapping("books")
	public String goBooks(){
		TimeChecker.TimeCheck("home map requested");
		return "home";
	}

}
