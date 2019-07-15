package RSAencryption;

import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkException;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.UrlJwkProvider;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import sun.security.rsa.RSAPublicKeyImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class Encryption {

    public static void main(String[] args) throws InvalidKeyException, JwkException, MalformedURLException {
//        createSecretToken();
        fetchToken();
    }

    static void createSecretToken() throws InvalidKeyException {

//        RSAPublicKey publicKey = new RSAPublicKeyImpl("test".getBytes());
//        RSAPrivateKey privateKey = ;
//        String temp = JWT.create()
//                .withIssuer("auth0")
//                .withClaim("email", "yo@ainbox.lv")
//                .sign(Algorithm.RSA256(publicKey,);
//        System.out.println("Token = " + temp);
    }



    static void fetchToken() throws JwkException, MalformedURLException {
        JwkProvider provider = new UrlJwkProvider(new URL("https://identify.nordea.com/api/dbf/ca/token-service-v3/keys"));
        Jwk jwk = provider.get("nasf-id-token");
        System.out.println(jwk);
    }
}
