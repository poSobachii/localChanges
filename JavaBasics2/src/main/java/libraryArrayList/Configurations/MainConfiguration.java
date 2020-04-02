package libraryArrayList.Configurations;

import libraryArrayList.Entity.Book;
import libraryArrayList.Services.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MainConfiguration {

    @Inject
    BookService bookService;

    @Bean
    void fillDatabase(){
            List<Book> bookList = new ArrayList<>();
            bookList.add(new Book("Lord of Rings", "new zeland", 1500));
            bookList.add(new Book("Harry potter", "jhoanna rowing", 1340));
            bookList.add(new Book("Avengers", "marvel", 2160));
            bookService.setBookList(bookList);
    }
}
