package MockitoWebTest;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationClass {

    @Bean
    public ObjectClass init(){
        System.out.println("------------- BEAN HAVE BEEN CREATED -------------");
        return new ObjectClass("yo Satan !");
    }

}
