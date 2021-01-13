package cachepak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
public class DoSmthService {

    @Autowired
    CalculationService calculationService;

    public String  doSmth(Integer input){
        int x = calculationService.doCalculate(input);
        return  "calculation result will be: " + x ;
    }

    @CacheEvict(value = "summ", allEntries = true)
    public String  resetCache(){
        return "Cache have been reseted";
    }

    public String putCache(Integer input){
        Integer x = calculationService.putCache(input);
        return "New cache have been puted " + input;
    }
}
