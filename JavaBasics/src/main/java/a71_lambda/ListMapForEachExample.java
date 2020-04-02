package a71_lambda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class ListMapForEachExample {

    public static void main(String[] args) {
//        listExample();
        mapExample();
    }

    static void listExample(){
        Person person = new Person();
        List<Person> rooster = person.fillTheRooster();

        getAnotherList(rooster);
    }

    static void getAnotherList(List<Person> persons){
        List<Person> personOlderThan30 = persons
                .stream()
                .filter(c -> c.getAge() > 30)
                .collect(Collectors.toList());

        personOlderThan30.forEach(x -> x.printPerson());

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
