package a71_lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComporatorExample {
    public static void main(String[] args) {

        Person person = new Person();
         List<Person> personList = person.fillTheRooster();


             // Sort with Inner Class
         Collections.sort(personList, new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                 return p1.getName().compareTo(p2.getName());

            }

        });

         System.out.println("=== Sorted Asc SurName ===");
         for (Person p : personList) {
             p.printPerson();

        }

             // Use Lambda instead

             // Print Asc
         System.out.println("=== Sorted Asc SurName ===");
         Collections.sort(personList, (Person p1, Person p2) -> p1.getName().compareTo(p2.getName()));

         for (Person p : personList) {
             p.printPerson();

        }

             // Print Desc
         System.out.println("=== Sorted Desc SurName ===");
         Collections.sort(personList, (p1, p2) -> p2.getName().compareTo(p1.getName()));

         for (Person p : personList) {
             p.printPerson();

        }


    }
}
