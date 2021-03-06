package JsonExample.Controller;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED_TYPE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Controller
@Path("/yo")
//@Produces({APPLICATION_JSON, APPLICATION_XML})
public class PathController {

    @Context
    private HttpServletRequest httpServletRequest;

    @GET
    public Response getUser() {
        return Response.status(200).entity("getUser is called").build();

    }

    @GET
    @Path("/vip")
    @Produces(APPLICATION_JSON)
    public Response getUserVIP() {
        System.out.println("http://localhost:8080/namepath/yo/vip -- requested");
        List<Key> to = new ArrayList<>();
        Key ks = new Key("alpha", "bravo", "charlie", "delta");
        to.add(ks);
        Keys ks2 = new Keys(to);
        return Response.status(200).entity(ks2).build();

    }

    @GET
    @Path("/get")
    public Response getParam(@QueryParam("code1") String code1, @QueryParam("code2") String code2, @QueryParam("code3") String code3) {
        System.out.println("Code1 parameter: " + code1);
        System.out.println("Code2 parameter: " + code2);
        System.out.println("Code3 parameter: " + code3);
        return null;
    }

    @POST
    @Path("/get")
    public Response postParam(@QueryParam("code1") String code1, @QueryParam("code2") String code2, @QueryParam("code3") String code3) {
        System.out.println("nothing happend to " + code1 + code2 + code3);
        return null;
    }

    @GET
    @Path("/getResponse")
    public Response getResponse(@QueryParam("code1") String code1, @QueryParam("code2") String code2, @QueryParam("code3") String code3) {
        String output = ("the GET summ is: " + code1 + " " + code2 + " " + code3);
        System.out.println("GET Incoming parametrs: " + code1 + code2 + code3);
        System.out.println("GET Outcoming parametrs: " + output);
        return Response.status(200).header("Custom-header", "blablabla")
                .header("Another-header", "Another blablabla").entity(output).build();
    }

    @POST
    @Path("/getResponse")
    public Response postResponse(@QueryParam("code1") String code1, @QueryParam("code2") String code2, @QueryParam("code3") String code3) {
        String output = ("the POST summ is: " + code1 + " " + code2 + " " + code3);
        System.out.println("POST Incoming parametrs: " + code1 + code2 + code3);
        System.out.println("POST Outcoming parametrs: " + output);
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/getJson")
//    @Produces(APPLICATION_JSON)
    public Response jsonResponse(@QueryParam("code1") String code1, @QueryParam("code2") String code2, @QueryParam("code3") String code3) {
        SomeDiffObjectRandom someDiffObjectRandom = new SomeDiffObjectRandom(code1, code2, code3);
        String output = ("the GET summ is: " + code1 + " " + code2 + " " + code3);
        System.out.println("GET Incoming parametrs: " + code1 + code2 + code3);
        System.out.println("GET Outcoming parametrs: " + output);
        return Response.status(200).header("Content-Type", "application/json")
                .header("Another header", "Another blablabla").entity(someDiffObjectRandom).build();
    }

    @POST
    @Path("/getJson")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response jsonPostResponse(@QueryParam("code1") String code1, @QueryParam("code2") String code2, @QueryParam("code3") String code3, final SomeDiffObjectRandom object) {
        String output = ("the POST summ is: " + code1 + " " + code2 + " " + code3);
        System.out.println("SomeDiffObjectRandom Incoming: " + object.getValue1() + " Value2: " + object.getValue2() + " Value3: " + object.getValue3());
        System.out.println("POST Incoming parametrs: " + code1 + code2 + code3);
        System.out.println("POST Outcoming parametrs: " + output);
        return Response.status(200)
                .header("Another header", "Another blablabla").entity(convertToJson(code1, code2, code3)).build();
    }

    @POST
    @Path("/getRandomJson")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response getRandomJson(){
        return Response.status(200)
                .entity(generateRandomJson()).build();
    }

    @POST
    @Path("/getPlain")
    @Consumes("text/plain")
    @Produces("text/plain")
    public Response plainPostResponse(final String json, @QueryParam("code1") String code1, @QueryParam("code2") String code2, @QueryParam("code3") String code3) {
        String output = ("the POST summ is: " + code1 + " " + code2 + " " + code3);
        System.out.println("JSON Incoming string: " + json);
        System.out.println("POST Incoming parametrs: " + code1 + code2 + code3);
        System.out.println("POST Outcoming parametrs: " + output);
        return Response.status(200)
                .header("Another header", "Another blablabla").entity(convertToJson(code1, code2, code3)).build();
    }

    public String generateRandomJson(){
        return "{\"somerandomthing\":{\"value1\":\"Yo\",\"list2\":{\"listvalue1\":\"Hello Kitty\", \"listvalue2\":\"Hello Santa\"}}}";
    }

    public String convertToJson(String value1, String value2, String value3) {
        SomeDiffObjectRandom converter = new SomeDiffObjectRandom(value1, value2, value3);
        Gson gson = new Gson();
        String json = gson.toJson(converter);
        System.out.println("CONVERTED JSON STRING: " + json);
        return json;
    }

    @POST
    @Path("/getUrlencoded")
    @Produces(APPLICATION_FORM_URLENCODED)
    public Response urlencodedBody() {
        return Response.status(200)
                .header("Some header", "value of header").entity("param1=data1&param2=data2&param3=data3").build();
    }

    @POST
    @Path("/getUrlencodedParam")
    @Consumes(APPLICATION_FORM_URLENCODED)
    @Produces(APPLICATION_FORM_URLENCODED)
    public Response urlencodedBodyWithParameters(@FormParam("name") String name) {
        System.out.println("Received parameter: " + name);
        return Response.status(200)
                .header("Some header", "value of header").entity("your parameter is = " + name).build();
    }

    @GET
    @Path("/servlet")
    public Response servletTesting() {
        System.out.println("/servlet requested");
        System.out.println("res=" + httpServletRequest.getQueryString());
        return Response.ok().build();
    }

    @GET
    @Path("/redirect2")
    public Response redirectUrl() throws URISyntaxException {
        System.out.println("redirect triggered");
        return Response.status(302).location(new URI("https://www.youtube.com")).build();
    }

    @GET
    @Path("/relocate")
    public Response relocatingTest() {
        return Response.status(Response.Status.FOUND).location(getUriCorrect()).build();
    }

    @GET
    @Path("/relocate2")
    public Response relocatingTest2() {
        return Response.status(302).header("Location", "https://youtube.com").build();
    }

    @GET
    @Path("/relocate3")
    public Response relocatingTest3() {
        System.out.println("relocated2");
        return Response.seeOther(getUriWrong()).build();
    }


    private URI getUriWrong() {
        try {
            return new URI("www.youtube.com");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    private URI getUriCorrect() {
        try {
            return new URI("http://youtube.com");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }
}
