import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FixCheck {

    public static void main(String[] args) {
        iftest(5);
    }


    static void putallmap(){
        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();
        map1.put("key1", "value1");
        map2.put("key2", "value2");
        map1.putAll(map2);
        System.out.println();
    }

    static void replaceallstring(){
        final String str1 = "Hello world";
        String str2 = str1.replaceAll("world", "peace");
        String str3 = str1.replaceAll("earth", "hell");
        String link1 = "www.google.com";
        String link2 = link1.replaceAll("www.", "https://");
        System.out.println(str2);
        System.out.println(link2);
    }

    static void ifStartsString(){
        String str1 = "Hello4World";
        String str2;
        if (str1.startsWith("Hello")) {
           str2 = str1.replaceAll("Hello", "Hi ");
        } else {
            str2 = "nothing happed";
        }
        System.out.println(str2);
    }

    static void constructorTest(){
        FixObject fixObject = new FixObject("Some", "object");
        System.out.println("result = " + fixObject);
    }

    static void iftest(int input){
        int x = 5;
        int y = 6;
        int z = 7;
        if (x != input && y != input){
            System.out.println("If done !");
        } else {
            System.out.println("If NOT done !!");
        }
    }
}
