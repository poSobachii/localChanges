package a111_spring.inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@ComponentScan("a111_spring.inject")
public class InjectConfiguration {

    String nameForDog;

    @Bean
    Dog makeNewDog(){
        return new Dog(nameForDog);
    }

    @PostConstruct
    void generateName(){
        this.nameForDog = "Cenna";
    }

//    @PostConstruct
//    @Bean
//    @PreDestroy

}
