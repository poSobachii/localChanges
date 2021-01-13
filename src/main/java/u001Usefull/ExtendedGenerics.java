package u001Usefull;

public class ExtendedGenerics {


    public static void main(String[] args) {

        Book book1 = getBook();
        Book book2 = getAdvanceBook();
        Book book3 = getGeneric(Book.class);
        AdvancedBook book4 = getGeneric(AdvancedBook.class);
        AdvancedBook book5 = getAdvancedGeneric();
        AdvancedBook advancedBook6 =  getAdvancedGeneric();

        Book book6 = null;
        if(advancedBook6 instanceof Book) {
            book6 = (Book) advancedBook6;
        }

        Book book8 = getBookGeneric();



        System.out.println("name is :" + book1.name);
        System.out.println("name2 is :" + book2.name);
        System.out.println("name3 is :" + book3.name);
        System.out.println("name4 is :" + book4.name);
        System.out.println("name5 is :" + book5.genre);
        System.out.println("name6 is :" + book6.name);
        System.out.println("name8 is :" + book8.name);
    }

    static Book getBook(){
        return new Book("monsters", "cameron", 1999);
    }

    static AdvancedBook getAdvanceBook(){
        return new AdvancedBook("dark siders", "king", 2999, 600, "horror");
    }

    static <T extends Book> T getGeneric(Class<T> type){
        if(type == Book.class){
            return type.cast(new Book("monsters", "cameron", 1999));
        }
        return type.cast(new AdvancedBook("dark siders", "king", 2999, 600, "horror"));
    }

    @SuppressWarnings("unchecked")
    static <T extends Book> T getBookGeneric(){
        return (T) new Book("monsters", "cameron", 1999);
    }

    static <T extends Book> T getAdvancedGeneric(){
        return (T) new AdvancedBook("dark siders", "king", 2999, 600, "horror");
    }
}


class Book {

    public String name;
    public String author;
    public Integer price;

    public Book(String name, String author, Integer price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

}

class AdvancedBook extends Book {

    public Integer pages;
    public String genre;

    public AdvancedBook(String name, String author, Integer price, Integer pages, String genre) {
        super(name, author, price);
        this.pages = pages;
        this.genre = genre;
    }
}