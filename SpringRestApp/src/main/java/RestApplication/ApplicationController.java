package RestApplication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ApplicationController {

    @Autowired
    private final BookShelf bookrep;

    ApplicationController(BookShelf bookrep) {
        this.bookrep = bookrep;
    }


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @ResponseBody
    String home(){
        return "Hello moose!";
    }

    @GetMapping("/books")
    List<Books> getAllBooks(){
        return bookrep.findAll();
    }

    @GetMapping("/books/{id}")
    Books getOneBookID(@PathVariable Long id) {

        return bookrep.findById(id)
                .orElseThrow(() -> new BookNFexception(id));
    }

//    @GetMapping("/books/{name}")
//    Books getOneBookName(@PathVariable String name) {
//
//            for (bookrep.findAll() : bookrep){
//                Long id =
//            }
//        return bookrep.findOne(id)
//                .orElseThrow(() -> new BookNFexception(id));
//    }

    @PostMapping("/books")
    Books newBook(@RequestBody Books tempBook) {
        return bookrep.save(tempBook);
    }

    @PutMapping("/books/{id}")
    Books replaceBook(@RequestBody Books newBook, @PathVariable Long id) {

        return bookrep.findById(id)
                .map(someExtraVariable -> {
                    someExtraVariable.setName(newBook.getName());
                    someExtraVariable.setAuthor(newBook.getAuthor());
                    someExtraVariable.setPublisher(newBook.getPublisher());
                    someExtraVariable.setPublication_date(newBook.getPublication_date());
                    return bookrep.save(someExtraVariable);
                })
                .orElseGet(() -> {
                    newBook.setId(id);
                    return bookrep.save(newBook);
                });
    }

    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id) {
        bookrep.deleteById(id);
    }


}
