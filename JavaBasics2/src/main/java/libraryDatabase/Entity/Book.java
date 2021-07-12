package libraryDatabase.Entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "BOOKSHELF")
@Table(name = "BOOKSHELF")
public class Book {


    @Id @GeneratedValue(strategy = IDENTITY) private Long id;
    @Column(name="BOOKNAME") private String name;
    @Column(name="BOOKAUTHOR") private String author;
    @Column(name="PRICE") private int price;
    @Column(name="IS_FAVORITE")
    private boolean isFavorited = true;
    @Column(name="IS_SOLD_OUT", columnDefinition="INT(1)")
    private boolean isSoldOut = true;
    @Column(name="is_documentary")
    @Type(type = "numeric_boolean")
    private boolean isDocumentary;

    Book(){
    }

    public Book(Long id, String name, String author, int price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isFavorited() {
        return isFavorited;
    }

    public void setFavorited(boolean favorited) {
        isFavorited = favorited;
    }

    public boolean isSoldOut() {
        return isSoldOut;
    }

    public void setSoldOut(boolean soldOut) {
        isSoldOut = soldOut;
    }

    public boolean isDocumentary() {
        return isDocumentary;
    }

    public void setDocumentary(boolean documentary) {
        isDocumentary = documentary;
    }
}
