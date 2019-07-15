package u001Usefull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEach {

    public static void main(String[] args) {
        List <String> templist = new ArrayList<>();
        templist.add("one");
        templist.add("two");
        templist.add("Three");


        for( String r : templist){
            System.out.println(r);
        }




        Map<String, String> map = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }

    }


}
