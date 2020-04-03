package RSAencryption;

import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkException;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.UrlJwkProvider;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import sun.security.rsa.RSAPublicKeyImpl;

import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class Encryption {

    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IlJrSTVNakk1T1VZNU9EYzFOMFE0UXpNME9VWXpOa1ZHTVRKRE9VRXpRa0ZDT1RVM05qRTJSZyJ9.eyJpc3MiOiJodHRwczovL3NhbmRyaW5vLmF1dGgwLmNvbS8iLCJzdWIiOiJhdXRoMHw1NjMyNTAxZjQ2OGYwZjE3NTZmNGNhYjAiLCJhdWQiOiJQN2JhQnRTc3JmQlhPY3A5bHlsMUZEZVh0ZmFKUzRyViIsImV4cCI6MTQ2ODk2NDkyNiwiaWF0IjoxNDY4OTI4OTI2fQ.NaNeRSDCNu522u4hcVhV65plQOiGPStgSzVW4vR0liZYQBlZ_3OKqCmHXsu28NwVHW7_KfVgOz4m3BK6eMDZk50dAKf9LQzHhiG8acZLzm5bNMU3iobSAJdRhweRht544ZJkzJ-scS1fyI4gaPS5aD3SaLRYWR0Xsb6N1HU86trnbn-XSYSspNqzIUeJjduEpPwC53V8E2r1WZXbqEHwM9_BGEeNTQ8X9NqCUvbQtnylgYR3mfJRL14JsCWNFmmamgNNHAI0uAJo84mu_03I25eVuCK0VYStLPd0XFEyMVFpk48Bg9KNWLMZ7OUGTB_uv_1u19wKYtqeTbt9m1YcPMQ";
    String validationToken = "https://jwt.io/";

    public static void main(String[] args) throws Exception {
//        createSecretToken();
//        fetchToken();
//        fetchToken2();
        fetchToken3();
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



    static void fetchToken() throws Exception {
        RSAKeys.Encryption ac = new RSAKeys.Encryption();
        JwkProvider provider = new UrlJwkProvider(new URL("https://po-sobachii.eu.auth0.com/.well-known/jwks.json"));
        Jwk jwk = provider.get("MkIyNjhCOEQxNjhDMTQ0RUZBRUQzQjI0ODIxNTVERDc0QUMxNDM4RA");
        System.out.println(jwk);
        System.out.println(jwk.getPublicKey());
        X509EncodedKeySpec spec = new X509EncodedKeySpec(jwk.getPublicKey().getEncoded());
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PublicKey pubkey = kf.generatePublic(spec);
    }

    static void fetchToken2() throws Exception {
        RSAKeys.Encryption ac = new RSAKeys.Encryption();
        JwkProvider provider = new UrlJwkProvider(new URL("https://identify.nordea.com/api/dbf/ca/token-service-v3/keys"));
        Jwk jwk = provider.get("demo-id-token");
        System.out.println(jwk);
        System.out.println(jwk.getPublicKey());
        X509EncodedKeySpec spec = new X509EncodedKeySpec(jwk.getPublicKey().getEncoded());
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PublicKey pubkey = kf.generatePublic(spec);
    }

    static void fetchToken3() throws Exception {
        RSAKeys.Encryption ac = new RSAKeys.Encryption();
        JwkProvider provider = new UrlJwkProvider(new URL("https://samples.auth0.com/.well-known/jwks.json"));
        Jwk jwk = provider.get("NkJCQzIyQzRBMEU4NjhGNUU4MzU4RkY0M0ZDQzkwOUQ0Q0VGNUMwQg");
        System.out.println(jwk);
        System.out.println(jwk.getPublicKey());
        X509EncodedKeySpec spec = new X509EncodedKeySpec(jwk.getPublicKey().getEncoded());
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PublicKey pubkey = kf.generatePublic(spec);
    }
}

