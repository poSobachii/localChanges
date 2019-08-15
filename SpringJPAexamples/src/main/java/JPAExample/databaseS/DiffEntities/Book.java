package JPAExample.databaseS.DiffEntities;


import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_detail_id")
    private BookDetail bookDetailus;

    public Book(){

    }

    public Book(String name){
        this.name = name;
    }

    public Book(String name, BookDetail bookDetail){
        this.name = name;
        this.bookDetailus = bookDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookDetail getBookDetail() {
        return bookDetailus;
    }

    public void setBookDetail(BookDetail bookDetail) {
        this.bookDetailus = bookDetail;
    }

    @Override
    public String toString() {
        return String.format(
                "Book[id=%d, name='%s', author='%s', number of pages='%d', release date='%d']",
                id, name, bookDetailus.getAuthor(), bookDetailus.getNumberOfPages(), bookDetailus.getPubDate());
    }
}
