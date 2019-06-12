package JsonExample.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


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
}
