package x029.StringUtillsPatterns;

import java.util.HashMap;
import java.util.Map;

public class StaticMap {


    private static final Map<String, String> CARS = new HashMap<>();

    static {
        CARS.put("1", "AUDI");
        CARS.put("2", "BWM");
        CARS.put("3", "VOLVO");

    }


    public static void main(String[] args) {

        System.out.println(CARS.get("2"));
        System.out.println(CARS.get("3"));
        System.out.println(CARS.getOrDefault("5", "Hello "));
        System.out.println(CARS.getOrDefault("3", "Hello"));
    }
}
