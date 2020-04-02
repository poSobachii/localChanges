package libraryArrayList.Entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name","author", "price" })
public class Book extends PreBook {

    int id;
    static int count = 1;


    public Book() {
        this.id = count;
        count++;
    }

    public Book(String name, String author, int price) {
        super(name,author,price);
        this.id = count;
        count++;
    }

    public int getId() {
        return id;
    }
}
