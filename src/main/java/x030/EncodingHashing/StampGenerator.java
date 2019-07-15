package x030.EncodingHashing;

import java.util.UUID;

public class StampGenerator {

    public static void main(String[] args) {
        for (int i = 0; i < 20 ; i++) {
            String temp2 = UUID.randomUUID().toString();
            String temp = UUID.randomUUID().toString().replace("-", "").toUpperCase().substring(0, 20);
            System.out.println(temp2);
        }

    }
}
