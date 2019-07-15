package RestWebApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.env.ConfigurableEnvironment;



@Configuration
@EnableAutoConfiguration
@ComponentScan

//@SpringBootApplication == @Configuration & EnableAutoConfiguration @ ComponentScan
//@EnableAutoConfiguration(exclude = {BookTestRep.class, TestH2DB.class, BookTestH2.class})
//@ComponentScan(excludeFilters =
//@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = TestH2DB.class))
//@ComponentScan(excludeFilters =
//@ComponentScan.Filter(type = FilterType.ASPECTJ, pattern ="RestWebApplication.TestHowToExclude.*" ))

public class AppStart {

        public static void main(String[] args) throws Exception {
            SpringApplication.run(AppStart.class, args);
        }

    }

