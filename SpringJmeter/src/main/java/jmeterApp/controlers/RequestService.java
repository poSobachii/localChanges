package jmeterApp.controlers;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class RequestService {

    int timesToInvoke = 10;
    int intervalInMiliSeconds = 300;


    public void invokeTestLoad() throws InterruptedException {
        for (int i = 1; i <= timesToInvoke; i++) {
            HttpClient httpClient = new DefaultHttpClient();
            try {
                URIBuilder builder = new URIBuilder();
                builder.setScheme("http").setHost("localhost:8080").setPath("/endpoint");
                URI uri = builder.build();
                HttpGet httpget = new HttpGet(uri);
                httpClient.execute(httpget);
                System.out.println("Request: " + httpget.toString() + " times: " + i);
            } catch (Exception ex) {
                System.out.println("error with : " + ex);

            } finally {
                Thread.sleep(intervalInMiliSeconds);
                httpClient.getConnectionManager().shutdown();
            }
        }
        System.out.println("Executed !");

    }

}