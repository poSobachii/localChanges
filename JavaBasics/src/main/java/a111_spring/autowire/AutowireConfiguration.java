package a111_spring.autowire;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
@ComponentScan("a111_spring.autowire")
public class AutowireConfiguration {

}

/*
        │ @Component │ generic stereotype for any Spring-managed component
        │ @Repository│ stereotype for persistence layer
        │ @Service   │ stereotype for service layer
        │ @Controller│ stereotype for presentation layer (spring-mvc)

*/
