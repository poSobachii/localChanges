package libraryArrayList.Controllers;

import libraryArrayList.Entity.Book;
import libraryArrayList.Entity.PreBook;
import libraryArrayList.Services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping("/")
public class MainController {

    @Inject
    BookService bookService;

    @GetMapping("/get/{id}")
    ResponseEntity getBook(@PathVariable int id) {
        return bookService.findOneBook(id);
    }

    @GetMapping(value = {"/", "/getAll"})
    ResponseEntity getAllBooks() {
        return new ResponseEntity<>(bookService.getBookList(), HttpStatus.OK);
    }

    @PostMapping("/modify/{id}")
    ResponseEntity modifyBook(@RequestBody Book updatedBook, @PathVariable int id) {
         return  bookService.modifyBook(id, updatedBook);
    }

    @PutMapping("/upload")
    ResponseEntity uploadBook(@RequestBody PreBook newBook) {
        bookService.addBooks(newBook);
        return  ResponseEntity.ok().body("Book successfully uploaded");
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity deleteBook(@PathVariable int id) {
        return bookService.deleteBook(id);
    }


}
