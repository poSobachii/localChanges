package JPAExample;

import JPAExample.databaseS.DiffEntities.Book;
import JPAExample.databaseS.DiffEntities.BookDetail;
import JPAExample.databaseS.Exceptions.ExceptionHandling;
import JPAExample.databaseS.Repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StartUp implements CommandLineRunner {

    @Bean
    public ExceptionHandling inti(){
        return new ExceptionHandling();
    }

    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(StartUp.class, args);
        System.out.println("App us Up !");
    }

    @Override
    public void run(String... strings) throws Exception {
        // save a couple of books
        List<Book> books = new ArrayList<>();
        books.add(new Book("Book A", new BookDetail(49, "Jhon", 2019)));
        books.add(new Book("Book B", new BookDetail(59, "Adam", 2016)));
        books.add(new Book("Book C", new BookDetail(69, "Jack", 2017)));
        bookRepository.saveAll(books);

        // fetch all books
        for (Book book : bookRepository.findAll()) {
            System.out.println((book.toString()));
        }
    }

}