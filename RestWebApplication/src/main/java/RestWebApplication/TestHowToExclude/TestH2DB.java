package RestWebApplication.TestHowToExclude;//package RestWebApplication.TestHowToExclude;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
//@Configuration
//public class TestH2DB {
//
//    @Autowired
//    BookTestRep booktestrepshelf;
//
////    @Bean
////    void initdb(){
////        booktestrepshelf.save(new BookTestH2("Cmsutra #1", "AlexGrey 18 y.o.","BrzzrsInd","2005"));
////        booktestrepshelf.save(new BookTestH2("Cmsutra #1", "AlexGrey 18 y.o.","BrzzrsInd","2005"));
////        booktestrepshelf.save(new BookTestH2("Cmsutra #1", "AlexGrey 18 y.o.","BrzzrsInd","2005"));
////        booktestrepshelf.save(new BookTestH2("Cmsutra #1", "AlexGrey 18 y.o.","BrzzrsInd","2005"));
////        booktestrepshelf.save(new BookTestH2("Cmsutra #1", "AlexGrey 18 y.o.","BrzzrsInd","2005"));
////        System.out.println("book are loaded");
////    }
//
//    @Bean
//    CommandLineRunner initDB(final BookTestRep booktestrepshelf) {
//        return args -> {
//            booktestrepshelf.save(new BookTestH2("Cmsutra #1", "AlexGrey 18 y.o.", "BrzzrsInd", "2005"));
//            booktestrepshelf.save(new BookTestH2("Cmsutra #1", "AlexGrey 18 y.o.", "BrzzrsInd", "2005"));
//            booktestrepshelf.save(new BookTestH2("Cmsutra #1", "AlexGrey 18 y.o.", "BrzzrsInd", "2005"));
//            booktestrepshelf.save(new BookTestH2("Cmsutra #1", "AlexGrey 18 y.o.", "BrzzrsInd", "2005"));
//            booktestrepshelf.save(new BookTestH2("Cmsutra #1", "AlexGrey 18 y.o.", "BrzzrsInd", "2005"));
//            System.out.println("book are loaded");
//        };
//    }
//
//}
