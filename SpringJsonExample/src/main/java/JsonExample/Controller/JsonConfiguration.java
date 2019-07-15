package JsonExample.Controller;

import JsonReader.InputString;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

@Configuration
public class JsonConfiguration {


    private final ObjectMapper mapper = new ObjectMapper();
    private static final String pathString = "/Users/aleksandrs.grisanovs/IdeaProjects/AccentureBootcamp/SpringJsonExample/jsonController.json";


    @Bean
    public JsonString loadFileString(){
        try (InputStream input = new FileInputStream(pathString)){
            JavaType type = mapper.getTypeFactory().constructCollectionType(Collection.class, JsonString.class);
            List<JsonString> jsonStringList = mapper.readValue(input, type);
            String name = jsonStringList.get(0).getName();
            String surname = jsonStringList.get(0).getSurname();
            int age = jsonStringList.get(0).getAge();
            String price = jsonStringList.get(0).getPrice();
            System.out.println("Bean: " + name + " "+ surname +" "+ age +" "+ price);
            return new JsonString(name, surname, age, price);
        } catch (IOException e) {
            System.out.println("-------------Error: " + e);
            throw new RuntimeException(e);
        }
    }

}
