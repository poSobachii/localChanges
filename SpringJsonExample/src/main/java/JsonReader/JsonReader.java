package JsonReader;

import JsonExample.Controller.JsonString;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.ws.rs.core.Response;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class JsonReader {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final String pathString = "/Users/aleksandrs.grisanovs/IdeaProjects/AccentureBootcamp/SpringJsonExample/keys.json";

    public static void main(String[] args) throws IOException, ParseException {
//        readFromFile();
        readFromWeb();
    }


    public static void readFromFile() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(pathString));

        JSONObject jsonObject = (JSONObject) obj;
        JSONArray solutions = (JSONArray) jsonObject.get("keys");

        for (Object e :solutions) {
            System.out.println(e);
        }
    }

    public static void readFromWeb(){
        JerseyClient client = JerseyClientBuilder.createClient();
        Response response = client.target("https://identify.nordea.com").path("/api/dbf/ca/token-service-v3/keys").request().get();
        KeyClass keyClass = response.readEntity(KeyClass.class);
        System.out.println(keyClass.getKeys());
        for (KeyValues keys : keyClass.getKeys()) {
            System.out.println("keys : " + keys.getKeyModules());

        }
        System.out.println("Executed !");
    }
}
