package GetInfoFromSite;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ApacheHttpRestClient2 {

    public final static void main(String[] args) {

        HttpClient httpClient = new DefaultHttpClient();
        try {
            HttpGet httpGetRequest = new HttpGet("http://www.ss.com/msg/lv/animals/dogs/cihua-hua/bbgcjn.html");

            // Execute HTTP request
            HttpResponse httpResponse = httpClient.execute(httpGetRequest);

            System.out.println("----------------------------------------");
            System.out.println ("STATUS LINE : " + httpResponse.getStatusLine());
            System.out.println("----------------------------------------");

            // Get hold of the response entity
            HttpEntity entity = httpResponse.getEntity();

            // If the response does not enclose an entity, there is no need
            // to bother about connection release
            byte[] buffer = new byte[1024];
            if (entity != null) {
                InputStream inputStream = entity.getContent();
                try {
                    int bytesRead = 0;
                    BufferedInputStream bis = new BufferedInputStream(inputStream);
                    while ((bytesRead = bis.read(buffer)) != -1) {
                        String chunk = new String(buffer, 0, bytesRead);
                        System.out.println(chunk);
                    }
                } catch (IOException ioException) {
                    // In case of an IOException the connection will be released
                    // back to the connection manager automatically
                    ioException.printStackTrace();
                } catch (RuntimeException runtimeException) {
                    // In case of an unexpected exception you may want to abort
                    // the HTTP request in order to shut down the underlying
                    // connection immediately.
                    httpGetRequest.abort();
                    runtimeException.printStackTrace();
                } finally {
                    // Closing the input stream will trigger connection release
                    try {
                        inputStream.close();
                    } catch (Exception ignore) {
                    }
                }
            }
        } catch (ClientProtocolException e) {
            // thrown by httpClient.execute(httpGetRequest)
            e.printStackTrace();
        } catch (IOException e) {
            // thrown by entity.getContent();
            e.printStackTrace();
        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpClient.getConnectionManager().shutdown();
        }
    }
}
