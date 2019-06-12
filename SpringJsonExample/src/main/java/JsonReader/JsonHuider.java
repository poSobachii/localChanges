package JsonReader;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JsonHuider implements LoggingClass {

    private final ObjectMapper mapper = new ObjectMapper();
    private static final String pathArray = "/Users/aleksandrs.grisanovs/IdeaProjects/AccentureBootcamp/SpringJsonExample/testJsonObjectV2.json";
    private static final String pathString = "/Users/aleksandrs.grisanovs/IdeaProjects/AccentureBootcamp/SpringJsonExample/testJsonString.json";
    private static final String pathObject = "/Users/aleksandrs.grisanovs/IdeaProjects/AccentureBootcamp/SpringJsonExample/testJsonObject.json";

    public static void main(String[] args) {
        logger.info("Example log from {}", JsonHuider.class.getSimpleName());
        loggerv2.info("Example log from  version V2 {}", JsonHuider.class.getSimpleName());
        LoggerExample.printSMTH();
        printArrayListObject();
//        printStringObject();
//        printObject();
    }


    private static void printArrayListObject(){
        logger.info("from this class - {}");
        loggerv2.warn("from this class version V2  - {}", JsonHuider.class.getSimpleName());
        JsonHuider json = new JsonHuider();
        List<InputObject> inputList =  new ArrayList<>(json.loadFileArray(pathArray, InputObject.class));
        for (InputObject r : inputList){
            System.out.println("obecjt: " + r.getId1());
            System.out.println("obecjt: " + r.getId2());
            System.out.println("obecjt: " + r.getId3());
        }
    }

    private static void printStringObject() {
        JsonHuider json = new JsonHuider();
        List<String> inputList = (List<String>) json.loadFileString();
        System.out.println(inputList);
    }

    private static void printObject(){
        JsonHuider json = new JsonHuider();
        json.loadObject();
    }

    private List<InputObject> loadFileArray(String fileName, Class c) {
        try (InputStream input = new FileInputStream(fileName)){
            JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, c);
            return mapper.readValue(input, type);
        } catch (IOException e) {
            System.out.println("-------------Error: " + e);
            throw new RuntimeException(e);
        }
    }

    private List<?> loadFileString(){
        try (InputStream input = new FileInputStream(pathString)){
            JavaType type = mapper.getTypeFactory().constructCollectionType(Collection.class, InputString.class);
            List<String> newlist = mapper.readValue(input, type);
            return mapper.readValue(input, type);
        } catch (IOException e) {
            System.out.println("-------------Error: " + e);
            throw new RuntimeException(e);
        }
    }

    private void loadObject() {
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(pathObject));

            JSONObject jsonObject = (JSONObject) obj;

            String name = (String) jsonObject.get("id1");
            String author = (String) jsonObject.get("id2");
            String age = (String) jsonObject.get("id3");

            System.out.println("Name: " + name);
            System.out.println("Author: " + author);
            System.out.println("Company List: " + age);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
