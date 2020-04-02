package a111_spring.inject;

import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.inject.Named;

@Service
public class ZooPark {

    @Inject
    Dog dog;

    @Inject
    Cat cat;

    public void punishAnimals() {
        System.out.println("Zoo have been opened");
        dog.bark();
        cat.mheow();
    }

}
