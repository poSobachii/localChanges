package libraryDatabase.DbDao;

public interface DatabaseDAO {
    String getPrint();
    void addBook(String name, String author, String publisher, String date);
    void deleteBook(String deletion);
    void fetchBook(String insert);
    void getAllBooks();
}
