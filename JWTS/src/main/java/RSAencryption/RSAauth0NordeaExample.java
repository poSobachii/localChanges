package RSAencryption;

import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkException;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.UrlJwkProvider;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.sql.Time;
import java.text.ParseException;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class RSAauth0NordeaExample {

    static String token = "eyJraWQiOiJwYXltZW50LXN0YWdpbmctNSIsInR5cCI6IkpXVCIsImFsZyI6IlJTMjU2In0.eyJhdWQiOiJodHRwczovL2lkZW50aWZ5Lm5vcmRlYS5jb20vYXBpL2RiZi9jYS90b2tlbi1zZXJ2aWNlLXYzL29hdXRoL3Rva2VuIiwic3ViIjoiY2I3NjM4MzktNzgxYi00MWVkLTg4NmItMTk5OTM0MjI1ZTYxIiwiaXNzIjoidnNHaEJkUzY3ZU5CeTFmYVJVQnkiLCJleHAiOjYxNTU2NzkyNDAwLCJqdGkiOiJwYXltZW50LXN0YWdpbmctNSJ9.IZNhjJSD_iPOIEFFwoQKY9GpBZhctisHktasUsoj-8xdxSrwUxlw_Dvpb8Q0D_f-Xpiph_JwfPgN6lq_vazDqUx4ZpT9uzfErYpIvu5k7zFqzpVvUBa-X7_k2StNQKkMaykya312lBQFlglLn4GT_f4GDCqh-HnD7xHGugyRczzUJXlqpvHYw0WGhOVUjh3b2Zffqrzj2MMVZTWx_U0eSm3pv0VykgZyQ76Pqs8XiXfG3tlQKlrZltBmLg2RDd9-esYZnuzPGjgqHJHlT22XfP_mOanRyfhf704p8Jg8PGqdWsrHw74iho9QiXB4bA2rSnbZsGBgXi1tNHgxjYCZ1g";
    static String token2 = "eyJ0dHlwIjoiYWNjZXNzX3Rva2VuIiwidmVyIjoiMy4xLjIiLCJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6Im5hc2YtYWNjZXNzLXRva2VuIn0.eyJzdWIiOiJuXC9hIiwiY291bnRyeSI6IkZJIiwiYyI6IkZJIiwiY2giOiJ3ZWIiLCJpc3MiOiJuYXNmLWFjY2Vzcy10b2tlbiIsImFsIjoyLCJhbSI6ImRlbW8iLCJjbGllbnRfaWQiOiJGVE4tU0FOT01BIiwic2lkIjoiYmNiOTJlYzktOTc4Ni00YzQzLWE4OTYtZDZjZDA1NGYzOWM2IiwibnR0IjoiZXh0IiwiYXVkIjpbIm5hc2YiLCJkYmYiLCJvc2wiXSwidWlkIjoiREVNT1VTRVIxIiwiY3Jpc3MiOiJub3JkZWEtZGVtbyIsIm5iZiI6MTU2NDk5Mjc2Niwic2NvcGUiOlsiZnRuX3BlcnNvbmlkZW50aWZpZXIiLCJvcGVuaWQiLCJmdG5faGV0dSIsImZ0bl9zYXR1Il0sInNnbSI6ImhvdXNlaG9sZCIsImV4cCI6MTU2NDk5Mjk1NiwiaWF0IjoxNTY0OTkyNzc2LCJqdGkiOiIzOWUyMmVmMzEwNWQ0ZjdiYTI2ZGVkNzNmNDg3MWE4YSJ9.l1mnD5CbnCbqRam-yb_g0PXsmiPzYcPsuSDhaRdYMxUneCS5oVJs725PaOaVmHBpUFxQ5RYRkydCfNC7YIJ2QeWJllEV85idw-9KI7ICNex0uzr29Pa_UkFhbfnuvw-lgRie8vyDhoFoi2Ukx9BsAo2j7AJTaJVCUhykLVUzIox1s6jjwXXcvnhY0AJGe8gzFmPn28rFgPROZ485ZrF7qSy0PKk0PVRReTChVQsvrx9yV3ALmEWNr-3c1wSr69EJbYKYPgYVkNPOsE_UwukX3hlLw_NoiXdPJuipyliWKOUxKq8oy42_QvWSlcCzDy_Y38b3qlGunT8SWobvOZENeg";
    static RSAPublicKey publicKeyFromFile;
    static RSAPrivateKey privateKey;
    static RSAPublicKey publicKeyFromURL;

    public static void main(String[] args) throws IOException, JwkException, InvalidKeySpecException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        RSAEncryptionFromFile.decodeToken();
        privateKey = RSAEncryptionFromFile.getPrivateKey();
        publicKeyFromFile = RSAEncryptionFromFile.getPublicKey();
        publicKeyFromURL = fetchByID();
        encodeToken();
//        decodeToken();
    }

    static void encodeToken() {
        String token = JWT.create()
                .withKeyId("payment-staging-5")
                .withIssuer("vsGhBdS67eNBy1faRUBy")
//                .withAudience("vsGhBdS67eNBy1faRUBy")
                .withAudience("https://identify.nordea.com/api/dbf/ca/token-service-v3/oauth/token")
                .withExpiresAt(new Date(System.currentTimeMillis() + 180000))
//                .withJWTId(UUID.randomUUID().toString())
                .withJWTId(UUID.randomUUID().toString())
                .withSubject(UUID.randomUUID().toString())
                .sign(Algorithm.RSA256(null, privateKey));
        System.out.println("Token=" + token);
    }

    static void decodeToken(){
        System.out.println("FILEPubic key is=" + Base64.getEncoder().encodeToString(publicKeyFromFile.getEncoded()));
        System.out.println("URLPubic key is=" + Base64.getEncoder().encodeToString(publicKeyFromURL.getEncoded()));
        System.out.println("FILEKEY=" + publicKeyFromFile);
        System.out.println("URLKEY=" + publicKeyFromURL);
        JWTVerifier verifier = JWT.require(Algorithm.RSA256(publicKeyFromURL, null))
                .withIssuer("nasf-access-token")
                .build();

        DecodedJWT parseClaimsJws = verifier.verify(token2);
        System.out.println("");
        System.out.println("Header     : " + parseClaimsJws.getHeader());
        System.out.println("Body       : " + parseClaimsJws.getPayload());
        System.out.println("Signature  : " + parseClaimsJws.getSignature());
        System.out.println("Claims : " + parseClaimsJws.getClaim("aud").asString());
    }


    public static RSAPublicKey fetchByID() throws JwkException, MalformedURLException {
        JwkProvider provider = new UrlJwkProvider(new URL("https://identify.nordea.com/api/dbf/ca/token-service-v3/keys"));
        Jwk jwk = provider.get("nasf-access-token");
//        System.out.println("JWK=" + jwk);
        RSAPublicKey RSApublicKey = (RSAPublicKey) jwk.getPublicKey();
        return RSApublicKey;
    }


}
