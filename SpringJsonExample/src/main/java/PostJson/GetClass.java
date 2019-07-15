package PostJson;

import JsonExample.Controller.SomeDiffObjectRandom;
import com.google.gson.Gson;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.net.URI;

public class GetClass {

    public static void get(){

//            HttpClient httpClient = new DefaultHttpClient();
//            HttpGet request = new HttpGet("http://localhost:8080/namepath/yo/getjson");
//            HttpParams params = new BasicHttpParams();
//            params.setParameter("code1", "Games");
//            params.setParameter("code2", "of");
//            params.setParameter("code3", "Thrones");
//            request.setParams(params);
//            httpClient.execute(request);

        HttpClient httpClient = new DefaultHttpClient();
        try {

            URIBuilder builder = new URIBuilder();
            builder.setScheme("http").setHost("localhost:8080").setPath("/namepath/yo/get")
                    .setParameter("code1", "games+\\")
                    .setParameter("code2", "of+\\")
                    .setParameter("code3", "fuckin thrones+\"");
            URI uri = builder.build();
            HttpGet httpget = new HttpGet(uri);
            httpClient.execute(httpget);

            System.out.println("Request: " + httpget.toString());
            System.out.println("Executed !");

        } catch (Exception ex) {
            System.out.println("error with : " + ex);

        } finally {
            System.out.println("Finished !");
            httpClient.getConnectionManager().shutdown();
        }
    }

    public static void getResponse(){
        try {
            HttpClient httpClient = new DefaultHttpClient();
            URIBuilder builder = new URIBuilder();
            builder.setScheme("http").setHost("localhost:8080").setPath("/namepath/yo/getResponse")
                    .setParameter("code1", "My\\")
                    .setParameter("code2", "house is")
                    .setParameter("code3", "green");
            URI uri = builder.build();
            HttpGet httpGet = new HttpGet(uri);
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity incoming = response.getEntity();
            printHeaders(response);
            String header1 = response.getFirstHeader("Custom-header").getValue();
            String header2 = response.getFirstHeader("Content-Type").getValue();
            System.out.println("FirstHeader: " + header1 + " " + header2);
            System.out.println("Response: " + EntityUtils.toString(incoming));
            System.out.println("Request: " + httpGet.toString());
            System.out.println("Executed !");
            httpClient.getConnectionManager().shutdown();
        } catch (Exception e ){
            System.out.println("error" + e);
        }
        System.out.println("Finished !");
    }

    public static void getJsonReponse(){
        try {
            HttpClient httpClient = new DefaultHttpClient();
            URIBuilder builder = new URIBuilder();
            builder.setScheme("http").setHost("localhost:8080").setPath("/namepath/yo/getJson")
                    .setParameter("code1", "My/")
                    .setParameter("code2", "house is")
                    .setParameter("code3", "green");
            URI uri = builder.build();
            HttpGet httpGet = new HttpGet(uri);
            HttpResponse response = httpClient.execute(httpGet);
            printHeaders(response);
            HttpEntity incoming = response.getEntity();
            String entityString = EntityUtils.toString(incoming);
            Gson gson = new Gson();
            SomeDiffObjectRandom object = gson.fromJson(entityString, SomeDiffObjectRandom.class);
            System.out.println("The Object is: Value1: " + object.getValue1() + " Value2: " + object.getValue2() + " Value3: " + object.getValue3());
            System.out.println("Response: " + entityString);
            System.out.println("Request: " + httpGet.toString());
            System.out.println("Executed !");
            httpClient.getConnectionManager().shutdown();
        } catch (Exception e ){
            System.out.println("error" + e);
        }
        System.out.println("Finished !");
    }


    public static void printHeaders(HttpResponse response){
        Header[] headers = response.getAllHeaders();
        for (Header header : headers) {
            System.out.println("Key : " + header.getName()
                    + " ,Value : " + header.getValue());
        }
    }
}
