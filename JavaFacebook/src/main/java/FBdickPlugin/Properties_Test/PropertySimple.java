package FBdickPlugin.Properties_Test;

import java.io.IOException;
import java.util.Properties;

public class PropertySimple {


    public static void main(String[] args) {

        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream("application.properties"));
        } catch (IOException e) {
            System.out.println("Error loading properties: " + e);
        }

        String test1 = properties.getProperty("message1");
        String test2 = properties.getProperty("message2");

        System.out.println(test1);
        System.out.println(test2);

    }
}
