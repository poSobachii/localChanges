package jquery.controller;

import java.util.ArrayList;
import java.util.List;

import jquery.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jquery.model.Employee;
import jquery.service.SomeRepository;

@RestController
public class EmployeeRestController {

    @Autowired
    private SomeRepository thisMegaShit;

    @RequestMapping(path = "/employeesXCV", method = RequestMethod.GET)
    public List<Employee> getAllEmployees() {
        TimeChecker.TimeCheck("employeesXCV requested");
        return thisMegaShit.getAllEmployees();
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable("id") long id) {
        return thisMegaShit.getEmployeeById(id);
    }

    @RequestMapping(path = "/booksXCV", method = RequestMethod.GET)
    public List<Employee> getAllBooks() {
        List list = new ArrayList();
        list.add((new Books("Cmsutra #4", "AlexGrey 30 y.o.","BrzzrsInd","2017")));
        list.add((new Books("Cmsutra #5", "AlexGrey 30 y.o.","BrzzrsInd","2017")));
        list.add((new Books("Cmsutra #6", "AlexGrey 30 y.o.","BrzzrsInd","2017")));
        list.add((new Books("Cmsutra #7", "AlexGrey 30 y.o.","BrzzrsInd","2017")));
        list.add((new Books("Cmsutra #8", "AlexGrey 30 y.o.","BrzzrsInd","2017")));
        TimeChecker.TimeCheck("booksXCV requsted");
        return list;
    }
}
