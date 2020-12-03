package a71_lambda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class ListMapForEachExample {

    public static void main(String[] args) {
        listExample();
//        mapExample();
    }

    static void listExample(){
        Person person = new Person();
        List<Person> rooster = person.fillTheRooster();

        getAnotherList(rooster);
        getOnePerson(rooster);
    }

    static void getAnotherList(List<Person> persons){
        List<Person> personOlderThan30 = persons
                .stream()
                .filter(c -> c.getAge() > 30 && c.getGender().equals(Person.Sex.FEMALE))
                .sorted((p1, p2) -> Integer.compare(p2.getAge(), p1.getAge()))
                .collect(Collectors.toList());

        personOlderThan30.forEach(x -> x.printPerson());

    }

    static void getOnePerson(List<Person> persons){
        Person person = persons.stream()
                .filter(c -> c.getAge() > 30 && c.getGender().equals(Person.Sex.FEMALE))

                .findFirst().orElse(null);
        System.out.println("person is - " + person.getName() + " aged: " + person.getAge());
    }

    static void mapExample(){
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        items.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));

        items.forEach((k,v)->{
            System.out.println("Item : " + k + " Count : " + v);
            if("E".equals(k)){
                System.out.println("Hello E");
            }
        });
    }


}
