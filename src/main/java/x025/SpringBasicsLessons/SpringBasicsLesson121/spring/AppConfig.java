package x025.SpringBasicsLessons.SpringBasicsLesson121.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import x025.SpringBasicsLessons.SpringBasicsLesson121.beans.Client;

@Configuration
@PropertySource("classpath:client121.properties")
@EnableAspectJAutoProxy
public class AppConfig {

    @Autowired
    private Environment environment;

    @Bean
    public Client client() {
        Client client = new Client();
        client.setId(environment.getRequiredProperty("id"));
        client.setFullName(environment.getRequiredProperty("name"));
        client.setGreeting(environment.getProperty("greeting"));
        return client;
    }

}
