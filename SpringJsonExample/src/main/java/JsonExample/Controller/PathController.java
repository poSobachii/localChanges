package JsonExample.Controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;

@Component
@Path("/yo")
//@Produces({APPLICATION_JSON, APPLICATION_XML})
public class PathController {


    @GET
    public Response getUser() {
        return Response.status(200).entity("getUser is called").build();

    }
    @GET
    @Path("/vip")
    @Produces(APPLICATION_JSON)
    public Response getUserVIP() {
        List<Key> to = new ArrayList<>();
        Key ks = new Key("alpha", "bravo", "charlie", "delta");
        to.add(ks);
        Keys ks2 = new Keys(to);
        return Response.status(200).entity(ks2).build();

    }

}
