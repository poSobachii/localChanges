package a111_spring.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TalkService {

//    @CustomQualifier("hello")
    @Autowired
    @Qualifier("bye")
    private Greetings greetings;

    public void doStuff() {
        greetings.pleaseTellMeSomething();
    }

}
