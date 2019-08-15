package JsonExample.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/keys")
public class MainController {

    @Inject
    JsonString jsonString;

    @GET
    @RequestMapping("/test")
    public Keys printKeysV2()  {
        List<Key> to = new ArrayList<>();
        Key ks = new Key("alpha", "bravo", "charlie", "delta");
        to.add(ks);
        Keys ks2 = new Keys(to);
        return ks2;
    }

    @GET
    @RequestMapping("/json")
    public JsonString readJsonFile(){
        return jsonString;
    }


    @GetMapping("/map")
    public MappedObject printmap(){
        Map<String, String> adress = new HashMap<>();
        adress.put("County", "Lotva");
        adress.put("City", "Riia");
        adress.put("Street name", "Douglas Street 5-6-78");
        adress.put("ZipCode", "ZipLine");
        MappedObject maps =
                new MappedObject("Stas", "Stasov", 30, adress, 19.99);
        return maps;
    }

    @PostMapping("/map")
    public String getPosttMap(@RequestBody MappedObject mapobject){
        System.out.println(mapobject.getName());
        return "OK";
    }
}
