package diffCheck;

import org.javers.core.Javers;
import org.javers.core.diff.Diff;
import org.springframework.beans.factory.annotation.Autowired;


public class DiffCheck {

    @Autowired
    private static Javers javers;


    public static void main(String[] args) {

        Book book1 = new Book("book1", "author1", 13);
        Book book2 = new Book("book1", "author1", 13);
        Diff diff = javers.compare(book1, book2);
        System.out.println("will do:" + diff.toString());
    }
}


class Book {
    String name;
    String author;
    Integer price;

    public Book(String name, String author, Integer price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}