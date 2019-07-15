package PostJson;

import JsonExample.Controller.SomeDiffObjectRandom;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.net.URI;

public class PostClass {

    public static void post() {
        try {
            HttpClient httpClient = new DefaultHttpClient();
            URIBuilder builder = new URIBuilder();
            builder.setScheme("http").setHost("localhost:8080").setPath("/namepath/yo/get")
                    .setParameter("code1", "hello")
                    .setParameter("code2", "this is")
                    .setParameter("code3", "STALINNN");
            URI uri = builder.build();
            HttpPost httpPost = new HttpPost(uri);
            httpClient.execute(httpPost);
            System.out.println("Request: " + httpPost.toString());
            System.out.println("Executed !");
            httpClient.getConnectionManager().shutdown();
        } catch (Exception e ){
            System.out.println("error" + e);
        }
        System.out.println("Finished !");
    }

    public static void postResponse(){
        try {
            HttpClient httpClient = new DefaultHttpClient();
            URIBuilder builder = new URIBuilder();
            builder.setScheme("http").setHost("localhost:8080").setPath("/namepath/yo/getResponse")
                    .setParameter("code1", "Your")
                    .setParameter("code2", "wife is")
                    .setParameter("code3", "cheating");
            URI uri = builder.build();
            HttpPost httpPost = new HttpPost(uri);
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity incoming = response.getEntity();
            System.out.println("Response: " + EntityUtils.toString(incoming));
            System.out.println("Request: " + httpPost.toString());
            System.out.println("Executed !");
            httpClient.getConnectionManager().shutdown();
        } catch (Exception e ){
            System.out.println("error" + e);
        }
        System.out.println("Finished !");
    }

    public static void postJson(){
        try {
            HttpClient httpClient = new DefaultHttpClient();
            URIBuilder builder = new URIBuilder();
            builder.setScheme("http").setHost("localhost:8080").setPath("/namepath/yo/getJson")
                    .setParameter("code1", "Your")
                    .setParameter("code2", "wife is")
                    .setParameter("code3", "cheating");
            URI uri = builder.build();
            HttpPost httpPost = new HttpPost(uri);
            String json = "{\"value1\":\"Yo\",\"value2\":\"i am\",\"value3\":\"Hello Kitty\"}";
            StringEntity entity = new StringEntity(json);
            httpPost.setEntity(entity);
            httpPost.setHeader("Content-Type", "application/json");
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity incoming = response.getEntity();
            String entityString = EntityUtils.toString(incoming);
            Gson gson = new Gson();
            SomeDiffObjectRandom object = gson.fromJson(entityString, SomeDiffObjectRandom.class);
            System.out.println("The Object is: Value1: " + object.getValue1() + " Value2: " + object.getValue2() + " Value3: " + object.getValue3());
            System.out.println("Response: " + entityString);
            System.out.println("Request: " + httpPost.toString());
            System.out.println("Executed !");
            httpClient.getConnectionManager().shutdown();
        } catch (Exception e ){
            System.out.println("error" + e);
        }
        System.out.println("Finished !");
    }


}
