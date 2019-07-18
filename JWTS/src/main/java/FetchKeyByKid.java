import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkException;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.UrlJwkProvider;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.PublicKey;

public class FetchKeyByKid {

    public static void main(String[] args) throws MalformedURLException, JwkException {
        JwkProvider provider = new UrlJwkProvider(new URL("https://identify.nordea.com/api/dbf/ca/token-service-v3/keys"));
        Jwk jwk = provider.get("nasf-id-token");
        PublicKey publicKey = jwk.getPublicKey();
        System.out.println(publicKey.toString());
//            X509EncodedKeySpec spec = new X509EncodedKeySpec(jwk.getPublicKey().getEncoded());
//            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//            PublicKey publickey = keyFactory.generatePublic(spec);
    }
}
