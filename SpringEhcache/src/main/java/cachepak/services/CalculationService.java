package cachepak.services;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "summ")
public class CalculationService {

    private Integer result = 0 ;

    @Cacheable("summ")
    public Integer doCalculate(Integer input){
        result = result + input;
        return  result;
    }

    @CachePut("summ")
    public Integer putCache(Integer input){
        result = input * 10;
        return result;
    }
}
