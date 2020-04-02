package libraryArrayList.Services;

import libraryArrayList.Entity.Book;
import libraryArrayList.Entity.PreBook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> bookList = new ArrayList<>();


    public void addBooks(PreBook in){
        bookList.add(new Book(in.getName(), in.getAuthor(), in.getPrice()));
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
                b.setPrice(updatedBook.getPrice());
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

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
