package a23_OOP;

import a23_OOP.animalLifecycle.Eat;
import a23_OOP.animalLifecycle.Lyfecycle;
import a23_OOP.animalTypes.Elephant;
import a23_OOP.animalTypes.Tiger;
import a23_OOP.animalTypes.Wolf;
import a23_OOP.animalTypes.Zebra;
import a23_OOP.convertor.HumanYearsConvertor;
import a23_OOP.itarator.Iterator;
import a23_OOP.repository.AnimalPool;
import a23_OOP.repository.Zoo;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        testCommand();
        testAdapter();
        testIntarator();
        testComposite();
        testPrototype();

    }

    static void testCommand() {

        Zebra zebra = new Zebra();
        Eat eat = new Eat(zebra);
        Lyfecycle lyfecycle = new Lyfecycle(eat);
        lyfecycle.doSomething();


    }

    static void testPrototype() throws CloneNotSupportedException {
        Wolf wolf1 = new Wolf();
        Wolf wolf2 = (Wolf) wolf1.clone();
        Wolf wolf3 = (Wolf) wolf2.clone();
    }

    static void testAdapter() {
        Elephant elephant = new Elephant();
        HumanYearsConvertor humanYearsConvertor = new HumanYearsConvertor(elephant);
        System.out.println(humanYearsConvertor.getHumanEquvalent());
    }

    static void testIntarator() {

        AnimalPool animalPool = new AnimalPool();
        Iterator iterator = animalPool.getIterator();

        while (iterator.hasNext()) {
            System.out.println("current Animal in pool = " + iterator.next());
        }
    }

    static void testComposite() {
        Zebra zebra1 = new Zebra();
        Zebra zebra2 = new Zebra();
        Zebra zebra3 = new Zebra();

        Elephant elephant1 = new Elephant();
        Elephant elephant2 = new Elephant();

        Tiger tiger1 = new Tiger();

        Wolf wolf1 = new Wolf();
        Wolf wolf2 = new Wolf();
        Wolf wolf3 = new Wolf();

        Zoo zoo1 = new Zoo();
        Zoo zoo2 = new Zoo();

        zoo1.addAnimal(zebra1);
        zoo1.addAnimal(zebra2);
        zoo1.addAnimal(elephant1);
        zoo1.addAnimal(tiger1);
        zoo1.addAnimal(wolf1);

        zoo2.addAnimal(zebra3);
        zoo2.addAnimal(elephant2);
        zoo2.addAnimal(wolf2);
        zoo2.addAnimal(wolf3);

        System.out.println("All Kinds:");
        System.out.println(zoo1.getKind());

        zoo1.killAnimal(tiger1);

        System.out.println("All kinds after removing tiger1 from zoo1");
        System.out.println(zoo1.getKind());
    }
}
