package u001Usefull;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MapValuesCheck {


    static HashMap<String, someObject> newObjectHashMap = new HashMap<>();
    static String input = "Name3";

    public static void main(String[] args) {

        someObject obj1 = new someObject("Name1", "Surname1", 10);
        someObject obj2 = new someObject("Name2", "Surname2", 20);
        someObject obj3 = new someObject("Name3", "Surname3", 30);
        someObject obj4 = new someObject("Name4", "Surname4", 40);

        newObjectHashMap.put("Key1", obj1);
        newObjectHashMap.put("Key2", obj2);
        newObjectHashMap.put("Key3", obj3);
        newObjectHashMap.put("Key4", obj4);

        System.out.println("result0=" + newObjectHashMap);
        System.out.println("results=" + getConditions());
        System.out.println("results2=" + getSurname());
    }

    static boolean getConditions() {

        return newObjectHashMap.entrySet().stream().
                anyMatch(element -> element.getValue().name.equals(input));

//        return matchedEntry.isPresent();
    }

    static String getSurname() {
        return newObjectHashMap.entrySet().stream().
                        filter(element -> element.getValue().name.equals(input)).findFirst().get().getValue().surname;
    }

    static String getSurnameSimplify() {
        Optional<Map.Entry<String, someObject>> matchedEntry =
                newObjectHashMap.entrySet().stream().
                        filter(element -> element.getValue().name.equals(input)).findFirst();
        someObject object = matchedEntry.get().getValue();
        return object.surname;
    }
}


/*    String userInput = "10-APR-2017";

    Optional<Map.Entry<Double, Incident>> matchedEntry =
            incidentHash.entrySet().stream().
                            filter(element -> element.getValue().getDate().equals(userInput)).findAny();

            matchedEntry.ifPresent(value->{
         //do something here
         });*/


class someObject {
    public String name;
    public String surname;
    public int years;

    public someObject(String name, String surname, int years) {
        this.name = name;
        this.surname = surname;
        this.years = years;
    }
}