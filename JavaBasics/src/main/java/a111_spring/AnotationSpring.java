package a111_spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.Scanner;

public class AnotationSpring {
    static  AbstractApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);

    public static void main(String args[]) {
//        simpleHelloWorld();
//        simpleConstructor();
        checkEquality();


        context.close();
    }

    static void simpleHelloWorld(){
        AnnotationHelloWorld obj1 = (AnnotationHelloWorld) context.getBean("helloWorldBean");
        obj1.someRandomMethod();
    }

    static void simpleConstructor(){
        AnnotationHelloWorld obj1 = (AnnotationHelloWorld) context.getBean("helloWorldConstructor");
        obj1.someRandomMethod();
    }

    static void checkEquality(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("type message:");
            String input = scanner.nextLine();
            switch(input){
                case "sing":
                    BeanUniqueness obj1 = (BeanUniqueness) context.getBean("helloSingleton");
                    obj1.printCreatingTime();
                    break;
                case "prot":
                    BeanUniqueness obj2 = (BeanUniqueness) context.getBean("helloPrototype");
                    obj2.printCreatingTime();
                    break;
                case "q":
                    return;
            }
        }
    }
}
