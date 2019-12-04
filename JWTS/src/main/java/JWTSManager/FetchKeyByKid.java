package JWTSManager;

import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkException;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.UrlJwkProvider;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

public class FetchKeyByKid {

    public static void main(String[] args) throws MalformedURLException, JwkException {
        System.out.println(fetchByID().toString());


//            X509EncodedKeySpec spec = new X509EncodedKeySpec(jwk.getPublicKey().getEncoded());
//            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//            PublicKey publickey = keyFactory.generatePublic(spec);
    }

    public static RSAPublicKey fetchByID() throws JwkException, MalformedURLException {
        JwkProvider provider = new UrlJwkProvider(new URL("https://papi.sanomaservices.nl/payment/public/identification/keys"));
        Jwk jwk = provider.get("papi-prod-01");
        System.out.println(jwk);
        RSAPublicKey RSApublicKey = (RSAPublicKey) jwk.getPublicKey();
        System.out.println("key= " + Base64.getEncoder().encodeToString(RSApublicKey.getEncoded()));
        return RSApublicKey;

    }
}
