package x024.SpringTests.SpringTests.webTests.HelloBean;

import org.springframework.context.annotation.Bean;


public class AppConfig {
    @Bean(name="myBeanus")
    public HelloWorld getHelloWorld(){
        return new HelloWorld();
    }

}