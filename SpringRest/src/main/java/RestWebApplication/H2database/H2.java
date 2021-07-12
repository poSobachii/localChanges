package RestWebApplication.H2database;

import RestWebApplication.DatabaseDAO.DatabaseDAO;
import RestWebApplication.Controller.AppController;
import RestWebApplication.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
//@ConditionalOnProperty(name = "conn.prop", havingValue = "h2")
@Profile("h2")
public class H2 implements DatabaseDAO {

    @Autowired
    private BookRepository bookrep;

    private Book booktemp;

    public H2() {

    }

    @Value("${welcome.message:msg_not_found}")
    private String message;

    @Override
    public String getPrint() {
        Book tempbk = (bookrep.findByAuthor("testAuthor"));
        List<Book> tempList = (bookrep.findByPublisher("PrintUK"));
        for (Book b:tempList) {
            System.out.println("lists are: " + b.getPublication_date());
        }
        System.out.println("testDate is : " + tempbk.getPublication_date());
        return message;
    }

    @Override
    public void addBook(String name, String author, String publisher, String date) {
        if (!name.isEmpty() && !author.isEmpty() && !publisher.isEmpty() && !date.isEmpty()) {
            bookrep.save(new Book(name, author, publisher, date));
            AppController.changeLine(new StringBuffer("<h3>New Book added !</h3>"));
        } else {
            AppController.changeLine(new StringBuffer("<h3>Please fill the form correctly!</h3>"));
        }

    }

    @Override
    public void deleteBook(String deletion) {
        if (!deletion.isEmpty()) {
            Book check = bookrep.findById(Long.parseLong(deletion)).orElse(null);
            if (check == null) {
                AppController.changeLine(new StringBuffer("<h3>There is no such book to delete !</h3>"));
            } else {
                bookrep.deleteById(Long.parseLong(deletion));
                AppController.changeLine(new StringBuffer("<h3>The book with ID: " + deletion + " is deleted!</h3>"));
            }
        } else {
            AppController.changeLine(new StringBuffer("<h3>Please type ID to delete !</h3>"));
        }
    }

    @Override
    public void fetchBook(String insert) {
        if (!insert.isEmpty()) {
            try {
                booktemp = bookrep.findById(Long.parseLong(insert)).orElse(null);
                AppController.changeLine(new StringBuffer("<h3> id: " +
                        booktemp.getId() + ", name: " + booktemp.getName() + ", author: " + booktemp.getAuthor() +
                        ", publisher: " + booktemp.getPublisher() + ", date: " + booktemp.getPublication_date() + "</h3>"));
            } catch (Exception e) {
                booktemp = bookrep.findBookByName(insert);
                String name = insert;
                String id = bookrep.findID(name);
                String author = bookrep.findAuthor(Long.parseLong(id));
                String publihser = bookrep.findPublisher(name);
                String date = bookrep.findDate(id);
                AppController.changeLine(new StringBuffer("<h3> id: " +
                        id + ", name: " + name + ", author: " + author +
                        ", publisher: " + publihser + ", date: " + date + "</h3>"));
            }

        } else {
            AppController.changeLine(new StringBuffer("<h3>Please type ID to search for the book !</h3>"));
        }

    }

    @Override
    public void getAllBooks() {
        System.out.println("H2 Bean involved");
        AppController.updateList(bookrep.findAll());
    }

}
