package libraryDatabase.Services;

import libraryDatabase.DbDao.DatabaseDAO;
import libraryDatabase.Entity.Book;
import libraryDatabase.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookService  implements DatabaseDAO {

    @Autowired
    BookRepository bookRepository;

    @Override
    public String getPrint() {
        return null;
    }

    @Override
    public void addBook(String name, String author, String publisher, String date) {

    }

    @Override
    public void deleteBook(String deletion) {

    }

    @Override
    public void fetchBook(String insert) {

    }

    @Override
    public void getAllBooks() {

    }



    public List<Book> bookList = new ArrayList<>();


    public void addBooks(Book in){
        bookRepository.save(in);
        bookList.add(in);
    }

    public ResponseEntity findOneBook(int id){
        for (Book b : bookList) {
            if (b.getId() == id){
                return new ResponseEntity<>(b,  HttpStatus.OK);
            }
        } return ResponseEntity.status(200).body("Book with id " + id + " not found");
    }

    public ResponseEntity modifyBook(int idToUpdate, Book updatedBook){
        for (int i = 0; i < bookList.size(); i++) {
            Book b = bookList.get(i);
            if (b.getId() == idToUpdate){
                b.setAuthor(updatedBook.getAuthor());
                b.setName(updatedBook.getName());
                return new ResponseEntity<>("Book with id " + idToUpdate + " have been updated",  HttpStatus.OK);
            }
        } return ResponseEntity.ok("Book with id " + idToUpdate + " not found");
    }

    public ResponseEntity deleteBook(int idToDelete){
        for (int i = 0; i < bookList.size() ; i++) {
            Book b = bookList.get(i);
            if (b.getId() == idToDelete){
                bookList.remove(i);
                return new ResponseEntity<>("Book with id " + idToDelete + " have been deleted",  HttpStatus.OK);
            }
        } return  ResponseEntity.ok("Book with id " + idToDelete + " not found");
    }

}
