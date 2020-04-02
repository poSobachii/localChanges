package a111_spring.autowire;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@CustomQualifier("bye")
public class GoodBye implements Greetings {

    public void pleaseTellMeSomething() {
        System.out.println("Ok GoodBye Pall!");
    }
}
