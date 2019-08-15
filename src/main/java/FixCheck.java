import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FixCheck {

    public static void main(String[] args) {

        methodOne(new HashMap<>());


    }

    static void methodOne(Map<String, String > parametrs){
        System.out.println(parametrs.isEmpty());
        parametrs.put("x", "KeyOne");
        System.out.println(parametrs.isEmpty());
        System.out.println(parametrs.get("x"));
    }
}
