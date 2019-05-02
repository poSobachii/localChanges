package com.mkyong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private GlobalProperties globalProperties;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }

    @Override
    public void run(String... args) {
        String test = globalProperties.getEmail();
        String tests = globalProperties.getMessage();
        String testoss = globalProperties.getSomeWrongMessage();
        int test2 = globalProperties.getThreadPool();
        System.out.println("email: " + test);
        System.out.println("number: " + test2);
        System.out.println("message: " + tests);
        System.out.println("must be wrong message: " + testoss);
    }
}
