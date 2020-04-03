package architest;

import org.springframework.stereotype.Component;

@Component
public class Hello implements Greetings {

    @Override
    public void pleaseTellMeSomething() {
        System.out.println("Well, Hello there");
    }
}
