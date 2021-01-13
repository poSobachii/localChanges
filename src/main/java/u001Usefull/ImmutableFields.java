package u001Usefull;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImmutableFields {


    public static void main(String[] args) {
        String name = "baeldung";
        String newName = name.replace("dung", "----");

        assertEquals("baeldung", name);
        assertEquals("bael----", newName);

        final List<String> strings = new ArrayList<>();
        assertEquals(0, strings.size());
        strings.add("baeldung");
//        assertEquals(0, strings.size());

        String s="Sachin";
        s.concat(" Tendulkar");//concat() method appends the string at the end
        System.out.println(s);//will print Sachin because strings are immutable objects

        String sx="Sachin";
        sx=sx.concat(" Tendulkar");
        System.out.println(sx);
    }
}
