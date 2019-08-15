package PostUrlenCoded;

import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.glassfish.jersey.client.JerseyWebTarget;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PostUrlencodedReq {

    static JerseyClient client = JerseyClientBuilder.createClient();
    static JerseyWebTarget webTarget;

    public static void main(String[] args) {
        simplePost();
    }


    static void simplePost() {
        Form form = new Form();
        form.param("name", "Alyssa William")
                .param("address", "1021 Hweitt Street")
                .param("phone-number", "343-343-3433");
//        webTarget = client.target("http://localhost:8080").path("namepath").path("yo").path("getUrlencodedParam");
        webTarget = client.target("http://localhost:8080/namepath/yo/getUrlencodedParam");
        Response rep = webTarget.request(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_FORM_URLENCODED)
                .post(Entity.form(form));
        String tempo = rep.readEntity(String.class);
        System.out.println("Results= " + tempo);
        System.out.println("Executed !");

    }
}
