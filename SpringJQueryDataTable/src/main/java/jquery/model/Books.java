package jquery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Books {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "bookName")
    private String name;
    @Column(name = "bookAuthor")
    private String author;
    @Column(name = "bookPublisher")
    private String publisher;
    @Column(name = "publication_date")
    private String publication_date;


    public Books(String name, String author, String publisher, String publication_date) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.publication_date = publication_date;
    }

    // @Data also uses getter and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(String publication_date) {
        this.publication_date = publication_date;
    }
}

