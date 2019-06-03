package JsonReader;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class JsonHuider {
    private final ObjectMapper mapper = new ObjectMapper();
    private static final String pathArray = "/Users/aleksandrs.grisanovs/IdeaProjects/AccentureBootcamp/SpringJsonExample/testJsonArray.json";
    private static final String pathString = "/Users/aleksandrs.grisanovs/IdeaProjects/AccentureBootcamp/SpringJsonExample/testJsonString.json";

    public static void main(String[] args) {
//        printArrayListObject();
        printStringObject();
    }



    private static void printArrayListObject(){
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
            return mapper.readValue(input, type);
        } catch (IOException e) {
            System.out.println("-------------Error: " + e);
            throw new RuntimeException(e);
        }
    }

}
