package a111_spring.inject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InjectSpring {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(InjectConfiguration.class);
        ZooPark zoo = (ZooPark) ctx.getBean("zooPark");
        zoo.punishAnimals();
        System.out.println("Hes name is Jhon " + zoo.dog.getName());
    }
}
