package HibernateDB;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "books",
        uniqueConstraints = { @UniqueConstraint(columnNames = { "id" }) })
public class Books {

    private Long id;
    private String bookName;
    private String bookAuthor;
    private String bookPublisher;
    private String publication_date;
    private Set<Books> books = new HashSet<Books>(0);


    Books(){
    }

    Books(String name, String author, String publisher, String publication_date){
        this.bookName = name;
        this.bookAuthor = author;
        this.bookPublisher = publisher;
        this.publication_date = publication_date;
    }

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "bookName")
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    @Column(name = "bookAuthor")
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    @Column(name = "bookPublisher")
    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    @Column(name = "publication_date")
    public void setPublication_date(String publication_date) {
        this.publication_date = publication_date;
    }

    public String getPublication_date() {
        return publication_date;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "books")
    public Set<Books> getBooks() {
        return books;
    }

    public void setBooks(Set<Books> books) {
        this.books = books;
    }
}
