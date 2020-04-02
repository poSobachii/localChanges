package a111_spring.inject;

import org.springframework.stereotype.Component;

import javax.inject.Named;

@Component
public class Cat {

    public void mheow() {
        System.out.println("Cat says get the f*ck my mouse");
    }
}
