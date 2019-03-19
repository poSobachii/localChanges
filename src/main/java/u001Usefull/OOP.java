package u001Usefull;

public class OOP {
    public static void main(String[] args) {

        System.out.println("Inheritance & Polimorphism EXAMPLE:");
        Object x = new Person();
        Object y = new Student();
        Person z = new Person();
        Student z1 = new Student();
        Person p = new Student();

        ((Person) x).read();
        ((Student) y).read();
        z.read();
        z1.read();
        p.read();

        System.out.println(" ");
        System.out.println("Abstract class & Interface EXAMPLE:");

        Animal anm = new Animal(){
            @Override
            void tempo() {

            }
        };
        anm.basicNeed();

        Animal anm2 = new Animal() {
            @Override
            void tempo() {

            }

            @Override
            void basicNeed(){
                System.out.println("now animal WILL GO EAT");
            }
        };
        anm2.basicNeed();
    }
}

class Person {

    void read(){
        System.out.println("the PERSON is reading");
    }

}

class Student extends Person{

    @Override
    void read(){
        System.out.println("the STUDENT is reading");
    }

}

abstract class Animal{
    void basicNeed(){
        System.out.println("the ANIMAL is drinking water");
    }

    abstract void tempo();
}
