package a111_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;

@Configuration
public class AnnotationConfig {

    @Bean(name = "helloWorldBean")
    public AnnotationHelloWorld helloWorld() {
        return new AnnotationHelloWorld();
    }

    @Bean(name = "helloWorldConstructor")
    public AnnotationHelloWorld helloWorld2() {
        return new AnnotationHelloWorld("Hell yeah !");
    }

    @Bean(name = "helloSingleton")
    @Scope("singleton")
    public BeanUniqueness methodNameDoesntMatter() {
        return new BeanUniqueness();
    }

    @Bean(name = "helloPrototype")
    @Scope("prototype")
    public BeanUniqueness methodNameDoesntMatter2() {
        return new BeanUniqueness();
    }
}

