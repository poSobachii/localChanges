package JWTSManager;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import sun.security.rsa.RSAPublicKeyImpl;

import java.security.InvalidKeyException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;


public class TokenAuth {

    public static String secret = "someString2";
    public static String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJhdXRoMCIsImVtYWlsIjoieW9AYWluYm94Lmx2In0.FKRIKSrQk8wlHyR8BttBDuaBAvU2WRppC0mElnus5gw";
    public static String tokenUnsecured = "eyJ0eXAiOiJKV1QiLCJhbGciOiJub25lIn0.eyJpc3MiOiJhdXRoMCIsImVtYWlsIjoic29tZS5sdiJ9.";

    public static void main(String[] args) {
//        createToken();
//        decodePart();
//        decodeToken();
//        createUnsecured();
//        decodeUnsecured();

    }

    public static void createToken() {
        String temp = JWT.create()
                .withIssuer("auth0")
                .withClaim("email", "yo@ainbox.lv")
                .sign(Algorithm.HMAC256(secret));
        System.out.println("Token =" + temp);

    }

    public static void createUnsecured(){
        String token = JWT.create()
                .withClaim("email", "some.lv")
                .withIssuer("auth0")
                .sign(Algorithm.none());
        System.out.println("Unsecured token: " + token);
    }

    public static void decodeUnsecured(){
        JWTVerifier verifier = JWT.require(Algorithm.none())
                .withIssuer("auth0")
                .build();
        DecodedJWT jwt = verifier.verify(tokenUnsecured);
        String temp = jwt.getClaim("email").asString();
        String temp2 = jwt.getHeader();
        String temp3 = jwt.getPayload();
        String temp4 = jwt.getSignature();
        System.out.println("Decoded Part info: " + temp + " " + temp2 + " " + temp3 +" " + temp4);

    }

    public static void decodePart() {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                .withIssuer("auth0")
                .build();
        DecodedJWT jwt = verifier.verify(token);
        String temp = jwt.getClaim("email").asString();
        String temp2 = jwt.getHeader();
        String temp3 = jwt.getPayload();
        String temp4 = jwt.getSignature();
        System.out.println("Decoded Part info: " + temp + " " + temp2 + " " + temp3 +" " + temp4);

    }

    public static void decodeToken() {
        Map<String, Claim> claims;
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                .withIssuer("auth0")
                .build();
        DecodedJWT jwt = verifier.verify(token);
        String temp = jwt.getKeyId();
        claims = jwt.getClaims();
        System.out.println("Decoded1 info: " + temp);
        System.out.println("Decoded2 info: " + claims.get("email").asString());
        for (Map.Entry<String, Claim> entry : claims.entrySet()) {
            System.out.println(entry.getKey() + " / " + entry.getValue().asString());
        }
    }
}
