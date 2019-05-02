package RestWebApplication.Entity;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BOOKSHELF")
public class Book {


    private @Id @GeneratedValue Long id;

    @Column(name="BOOKNAME")
    private String name;

    @Column(name="BOOKAUTHOR")
    private String author;

    @Column(name="BOOKPUB")
    private String publisher;

    @Column(name="PUBDATE")
    private String publication_date;

//    private Set<Book> books = new HashSet<Book>(0);


    Book(){
    }

    public Book(Long id, String name, String author, String publisher, String publication_date){
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.publication_date = publication_date;
    }

    public Book(String name, String author, String publisher, String publication_date){
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.publication_date = publication_date;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublication_date(String publication_date) {
        this.publication_date = publication_date;
    }

    public String getPublication_date() {
        return publication_date;
    }

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "books")
//    public Set<RestWebApplication.Hibernate.HibernateDB.Book2> getBooks() {
//        return books;
//    }
//
//    public void setBooks(Set<RestWebApplication.Hibernate.HibernateDB.Book2> books) {
//        this.books = books;
//    }
}
