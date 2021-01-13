package cachepak.controllers;

import cachepak.services.DoSmthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @Autowired
    DoSmthService doSmthService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String defaultPath(@RequestParam int input){
        return  doSmthService.doSmth(input);
    }

    @RequestMapping(value = "/reset", method = RequestMethod.GET)
    public String resetCache(){
        return  doSmthService.resetCache();
    }

    @RequestMapping(value = "/put", method = RequestMethod.GET)
    public String putCache(@RequestParam int input){
        return doSmthService.putCache(input);
    }
}
