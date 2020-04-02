package a71_lambda;

import java.util.LinkedList;
import java.util.List;

import static a71_lambda.Person.Sex.FEMALE;
import static a71_lambda.Person.Sex.MALE;


public class IFexampleArgument {

    public static void main(String[] args) {
        Person person = new Person();
        List<Person> rooster = person.fillTheRooster();

        printPersonsOlderThan(rooster, 30);
        printPersons(rooster, new CheckPerson() {
                    public boolean test(Person p) {
                        return p.getGender() == MALE
                                && p.getAge() >= 60
                                && p.getAge() <= 70;
                    }
                }
        );
        printPersons(
                rooster,
                (Person p) -> p.getGender() == MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25
        );

    }



    static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() <= age) {
                p.printPerson();
            }
        }
    }

    static void printPersons(
            List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

}


interface CheckPerson {
    boolean test(Person p);
}

class Person {

   public enum Sex {
       MALE, FEMALE
   }

   String name;
   int age;
   Sex gender;

    public Person(String name, int age, Sex gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person(){}

    public int getAge() {
       return age;
   }

   public Sex getGender(){
        return gender;
    }

    public String getName(){
        return name;
    }

   public void printPerson() {
       System.out.println("My name:" + name);
   }

   public List<Person> fillTheRooster(){
        List<Person> rooster = new LinkedList<>();
       rooster.add(new Person("Jhon", 22, MALE));
       rooster.add(new Person("Jim", 35, MALE));
       rooster.add(new Person("Jersey", 19, FEMALE));
       rooster.add(new Person("Chirsti", 29, FEMALE));
       rooster.add(new Person("Rock", 34, MALE));
       rooster.add(new Person("Bradley", 29, MALE));
       rooster.add(new Person("Vicky", 23, FEMALE));
       rooster.add(new Person("OldHarry", 65, MALE));
       rooster.add(new Person("OldBetty", 64, FEMALE));
        return rooster;
   }
}