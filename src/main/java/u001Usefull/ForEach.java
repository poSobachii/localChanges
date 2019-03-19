package u001Usefull;

import java.util.ArrayList;
import java.util.List;

public class ForEach {

    public static void main(String[] args) {
        List <String> templist = new ArrayList<>();
        templist.add("one");
        templist.add("two");
        templist.add("Three");


        for( String r : templist){
            System.out.println(r);
        }


    }


}
