package RestApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadThatBeast {

    @Bean
    CommandLineRunner initDatabase(final BookShelf bookrep) {
        return args -> {
            bookrep.save(new Books("Cmsutra #1", "AlexGrey 18 y.o.","BrzzrsInd","2005"));
            bookrep.save(new Books("Cmsutra #2", "AlexGrey 20 y.o.","BrzzrsInd","2007"));
            bookrep.save(new Books("Cmsutra #3", "AlexGrey 23 y.o.","BrzzrsInd","2010"));
            bookrep.save(new Books("Cmsutra #4", "AlexGrey 26 y.o.","BrzzrsInd","2013"));
            bookrep.save(new Books("Cmsutra #5", "AlexGrey 30 y.o.","BrzzrsInd","2017"));
            System.out.println("Books are loaded");
        };
    }
}
