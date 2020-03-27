package library.Controllers;

import library.Entity.Book;
import library.Entity.PreBook;
import library.Services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
