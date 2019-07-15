package u001Usefull;

import java.util.ArrayList;
import java.util.List;

public class StringEquality {
    static List<String> stringList;

    public static void main(String[] args) {
        stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("plum");
        stringList.add("orange");
        stringList.add("banana");

        String equality = "banana";
        if (stringList.contains(equality)) {
            System.out.println("list");
            if (equality.matches("green|blue|yellow")) {
                System.out.println("matches");
            }
            if (equality.matches("banana|orange|apple")) {
                System.out.println("matches #2");
            } else {
                System.out.println("done");
            }
        }
    }
}
