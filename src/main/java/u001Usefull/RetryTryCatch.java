package u001Usefull;

import java.util.HashMap;
import java.util.Map;

public class RetryTryCatch {

    public static int x = 0;
    public static int z = 4;


    public static void main(String[] args) {
        letsgo(10);
    }


    public static void replace() {
        x = 2;
    }


    public static void letsgo(int y){
        int attempcounter = 1;
        try {
            System.out.println("answer: " + z / x + "int:" + y);
        } catch (Exception e) {
            if (attempcounter == 1) {
                System.out.println("Error : " + e);
                replace();
                letsgo(y);
            } else {throw e; }
        }
    }
}
