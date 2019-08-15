package JPAExample.databaseS.DiffEntities;

import javax.persistence.*;

@Entity
@Table(name = "book_detail")
public class BookDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "number_of_pages")
    private Integer numberOfPages;

    @Column(name = "author")
    private String author;

    @Column(name = "publishing_year")
    private int pubDate;

    @OneToOne(mappedBy = "bookDetailus")
    private Book book;

    public BookDetail(){

    }

    public BookDetail(Integer numberOfPages, String author, int pubDate) {
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.pubDate = pubDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getAuthor() {
        return author;
    }

    public int getPubDate() {
        return pubDate;
    }
}