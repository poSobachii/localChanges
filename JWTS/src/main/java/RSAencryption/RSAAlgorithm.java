package RSAencryption;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;
import java.util.Date;

public class RSAAlgorithm {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("RSA");
        keyGenerator.initialize(1024);

        KeyPair kp = keyGenerator.genKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) kp.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) kp.getPrivate();

        String encodedPublicKey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        String encodedPrivate = Base64.getEncoder().encodeToString(privateKey.getEncoded());
        System.out.println(convertToPublicKey(encodedPublicKey));
        System.out.println(convertToPrivateKey(encodedPrivate));
        String token = generateJwtToken(publicKey, privateKey);
        System.out.println("TOKEN:");
        System.out.println(token);
        printStructure(token, publicKey, privateKey);
    }

    public static String generateJwtToken(RSAPublicKey publickey, RSAPrivateKey privateKey) {
        String token = JWT.create()
                .withIssuer("adam")
                .withClaim("Date", new Date(2018, 1, 1))
                .withClaim("email", "info@wstutorial.com")
                .sign(Algorithm.RSA256(publickey, privateKey));
        return token;
    }

    //Print structure of JWT
    public static void printStructure(String token, RSAPublicKey publicKey, RSAPrivateKey privatekey) {
        JWTVerifier verifier = JWT.require(Algorithm.RSA256(publicKey, privatekey))
                .withIssuer("adam")
                .build();
        DecodedJWT parseClaimsJws = verifier.verify(token);
        System.out.println("");
        System.out.println("Header     : " + parseClaimsJws.getHeader());
        System.out.println("Body       : " + parseClaimsJws.getPayload());
        System.out.println("Signature  : " + parseClaimsJws.getSignature());
    }


    // Add BEGIN and END comments
    private static String convertToPublicKey(String key){
        StringBuilder result = new StringBuilder();
        result.append("-----BEGIN PUBLIC KEY-----\n");
        result.append(key);
        result.append("\n-----END PUBLIC KEY-----");
        return result.toString();
    }

    private static String convertToPrivateKey(String key){
        StringBuilder result = new StringBuilder();
        result.append("-----BEGIN PRIVATE KEY-----\n");
        result.append(key);
        result.append("\n-----END PRIVATE KEY-----");
        return result.toString();
    }



}

