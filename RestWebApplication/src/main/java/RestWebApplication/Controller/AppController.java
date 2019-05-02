package RestWebApplication.Controller;


import RestWebApplication.DatabaseDAO.DatabaseDAO;
import RestWebApplication.Entity.Book;

import RestWebApplication.jQuery.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {

    @Inject
    private DatabaseDAO dbase;

    static StringBuffer strbuff;
    static List bookList = new ArrayList();


    public static void updateList(List tempo){ bookList = tempo; }

    public static void changeLine(StringBuffer tempo){
        strbuff = tempo;
    }

    public static StringBuffer getStrbuff() {
        return strbuff;
    }

    @RequestMapping(value = {"/", "home"})
    public String welcome() {
        strbuff = null;
        System.out.println("System message : " + dbase.getPrint());

        return "home";
    }

    @RequestMapping("showAll")
    public String showAll(){
        dbase.getAllBooks();
        jQueryTablePrint.printTable();
        return "home";
    }


    @GetMapping("search")
    public String searchBook(HttpServletRequest request, HttpServletResponse response) {
        String reqstd = request.getParameter("search");
        dbase.fetchBook(reqstd);
        return "home";
    }

    @GetMapping("deleteBook")
    public String deleteBook(HttpServletRequest request, HttpServletResponse response){
        String reqstd = request.getParameter("delete");
        dbase.deleteBook(reqstd);
        return "home";
    }

    @GetMapping("addBook")
    public String addBook(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("Bname");
        String auth = request.getParameter("Bauthor");
        String pub = request.getParameter("Bpublisher");
        String date = request.getParameter("Bdate");
        dbase.addBook(name,auth,pub,date);
        return "home";
    }

    @GetMapping("/booksXCV")
    @ResponseBody
    public List<Book> getAllBooks() {
        return bookList;
    }
}