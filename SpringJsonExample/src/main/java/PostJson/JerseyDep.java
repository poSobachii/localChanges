package PostJson;

import JsonExample.Controller.SomeDiffObjectRandom;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.glassfish.jersey.client.JerseyWebTarget;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;


public class JerseyDep {

    static JerseyClient client = JerseyClientBuilder.createClient();
    static JerseyWebTarget webTarget;

    public static void main(String[] args) {
//        simpleget();
//        paramget();
//        responseget();
//        getJson();

//        paramPost();
        responsePost();
//        jsonPost();
    }


    static void simpleget(){
        client.target("http://localhost:8080").path("/namepath/yo/vip/").request().get();
        System.out.println("Executed !");
    }

    static void paramget(){
        webTarget = client.target("http://localhost:8080").path("namepath").path("yo").path("get");
        webTarget.queryParam("code1", "1this was")
                .queryParam("code2", "2an example")
                .queryParam("code3", "3of Jersey param query").request().get();
        System.out.println("Executed !");

    }

    static void responseget(){
//        MultivaluedMap<String, String> headermap = new MultivaluedHashMap<>();
        webTarget = client.target("http://localhost:8080").path("namepath").path("yo").path("getResponse");
        Response response = webTarget.queryParam("code1", "lets")
                .queryParam("code2", "get")
                .queryParam("code3", "response in Jersey").request().get();
        String incoming = response.readEntity(String.class);
        String header = response.getHeaderString("Another-header");
        System.out.println("Header retrieved with: " + header);
        System.out.println("Entity: " + incoming);
        System.out.println("Executed !");
    }

    static void getJson(){
//        webTarget = client.target("http://localhost:8080").path("namepath").path("yo").path("getJson");
        Response response = client.target("http://localhost:8080").path("namepath").path("yo").path("getJson").queryParam("code1", "Get me")
                .queryParam("code2", "that")
                .queryParam("code3", "Json object")
                .request().get();
        SomeDiffObjectRandom object = response.readEntity(SomeDiffObjectRandom.class);
        System.out.println("The Object values = Value1: " + object.getValue1() + " Value2: " + object.getValue2() + " Value3: " + object.getValue3());
        System.out.println("Executed !");

    }

    static void paramPost(){
        webTarget = client.target("http://localhost:8080").path("namepath").path("yo").path("get");
        webTarget.queryParam("code1", "this was")
                .queryParam("code2", "an example")
                .queryParam("code3", "of JERSEY POST").request().post(null);
        System.out.println("Executed !");
    }

    static void responsePost(){

        MultivaluedMap<String, String> formData = new MultivaluedHashMap<String, String>();
        formData.add("code1", "value1");
        formData.add("code2", "value2");

        webTarget = client.target("http://localhost:8080").path("namepath").path("yo").path("getResponse");
        Response response = webTarget.queryParam("code1", "lets")
                .queryParam("code2", "get")
                .queryParam("code3", "response in Jersey").request().post(null);
        String incoming = response.readEntity(String.class);
        String header = response.getHeaderString("Another-header");
        System.out.println("Header retrieved with: " + header);
        System.out.println("Entity: " + incoming);
        System.out.println("Executed !");
    }

    static void jsonPost(){
        String entity =    "{\"value1\": \"please\", \"value2\": \"get\", \"value3\": \"off\" }";
        SomeDiffObjectRandom objectRandom = new SomeDiffObjectRandom("plz", "get me", "this Json");
        webTarget = client.target("http://localhost:8080").path("namepath").path("yo").path("getJson");
        Response response = webTarget.queryParam("code1", "Get me")
                .queryParam("code2", "that")
                .queryParam("code3", "Json object")
                .request(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON).post(Entity.entity(entity, MediaType.APPLICATION_JSON_TYPE));

//        Response response = webTarget.request(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON).method("POST", Entity.json(entity));

        SomeDiffObjectRandom object = response.readEntity(SomeDiffObjectRandom.class);
        System.out.println("The Object values = Value1: " + object.getValue1() + " Value2: " + object.getValue2() + " Value3: " + object.getValue3());
        System.out.println("Executed !");
    }

}
