package a112_rest_spring.RestController;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Component
public class smartMap {

    public Map<String, List<?>> generateSuperMap(){
        Map<String, List<?>> superMap = new HashMap<>();
        superMap.put("Strings", generateStringList());
        superMap.put("Integers", generateIntegerList());
        superMap.put("Boolenas", generateBooleanList());
        superMap.put("Objects", generateRandomObjList());
        return superMap;
    }

    List<String> generateStringList(){
        List<String> stringList = new ArrayList<>();
        stringList.add("name");
        stringList.add("surname");
        stringList.add("age");
        return stringList;
    }

    List<Integer> generateIntegerList(){
        List<Integer> intList = new ArrayList<>();
        intList.add(100);
        intList.add(101);
        intList.add(102);
        return intList;
    }

    List<Boolean> generateBooleanList(){
        List<Boolean> booleans = new ArrayList<>();
        booleans.add(true);
        booleans.add(false);
        booleans.add(true);
        return booleans;
    }

    List<absoluteRandomObject> generateRandomObjList(){
        List<absoluteRandomObject> objects = new ArrayList<>();
        objects.add(new absoluteRandomObject("name", true));
        objects.add(new absoluteRandomObject("name2", false));
        objects.add(new absoluteRandomObject("name3", true));
        return objects;
    }


//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    class absoluteRandomObject{

        String name;
        boolean state;

        public absoluteRandomObject(String name, boolean state) {
            this.name = name;
            this.state = state;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isState() {
            return state;
        }

        public void setState(boolean state) {
            this.state = state;
        }
    }
}
