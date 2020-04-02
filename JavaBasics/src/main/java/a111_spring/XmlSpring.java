package a111_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class XmlSpring {

    static ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

    public static void main(String[] args) {
        simpleHello();
//        oneClassTwoBeans();
//        beanWithConstructor();
//        beanWithMultipleConstructor();
//        singletonANDprotoype();
//        checkEquality();
    }

    static void simpleHello(){
        XmlHelloWorld obj1 = (XmlHelloWorld) context.getBean("helloWorld");
        obj1.someRandomMethod();
    }

    static void oneClassTwoBeans(){
        XmlHelloWorld obj1 = (XmlHelloWorld) context.getBean("helloWorld");
        obj1.someRandomMethod();
        XmlHelloWorld obj2 = (XmlHelloWorld) context.getBean("helloWorld2");
        obj2.someRandomMethod();
    }

    static void beanWithConstructor(){
        XmlHelloWorld obj1 = (XmlHelloWorld) context.getBean("helloWorld31");
        obj1.someRandomMethod();
        XmlHelloWorld obj2 = (XmlHelloWorld) context.getBean("helloWorld32");
        obj2.someRandomMethod();
        XmlHelloWorld obj3 = (XmlHelloWorld) context.getBean("helloWorld33");
        obj3.someRandomMethod();

    }

    static void beanWithMultipleConstructor(){
        XmlHelloWorld obj1 = (XmlHelloWorld) context.getBean("helloWorld41");
        obj1.someRandomMethod();
    }

    static  void singletonANDprotoype(){
        XmlHelloWorld obj1 = (XmlHelloWorld) context.getBean("helloWorld51");
        XmlHelloWorld obj2 = (XmlHelloWorld) context.getBean("helloWorld51");
        obj1.someRandomMethod();
        System.out.println(obj1.equals(obj2));
        System.out.println(obj1 + "\n" + obj2);

        XmlHelloWorld obj11 = (XmlHelloWorld) context.getBean("helloWorld52");
        XmlHelloWorld obj12 = (XmlHelloWorld) context.getBean("helloWorld52");
        obj11.someRandomMethod();
        System.out.println(obj11.equals(obj12));
        System.out.println(obj11 + "\n" + obj12);
    }

    static void checkEquality(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("type message:");
            String input = scanner.nextLine();
            switch(input){
                case "sing":
                    BeanUniqueness obj1 = (BeanUniqueness) context.getBean("uniqueBean1");
                    obj1.printCreatingTime();
                    break;
                case "prot":
                    BeanUniqueness obj2 = (BeanUniqueness) context.getBean("uniqueBean2");
                    obj2.printCreatingTime();
                    break;
                case "q":
                    return;
            }
        }
    }
}
