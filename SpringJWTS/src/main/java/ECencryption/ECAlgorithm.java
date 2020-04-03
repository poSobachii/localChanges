package ECencryption;

import RSAencryption.PemUtils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;
import java.util.Date;

import static RSAencryption.PemUtils.readPublicKeyFromFile;


public class ECAlgorithm {

    public static String path = "/Users/aleksandrs.grisanovs/IdeaProjects/AccentureBootcamp/JWTS/KeyPair/ECpublicK.pem";

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("EC");
        keyGenerator.initialize(571);

        KeyPair kp = keyGenerator.genKeyPair();
        ECPublicKey publicKey = (ECPublicKey) kp.getPublic();
        ECPrivateKey privateKey = (ECPrivateKey) kp.getPrivate();

        String encodedPublicKey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        String encodedPrivate = Base64.getEncoder().encodeToString(privateKey.getEncoded());
        System.out.println(convertToPublicKey(encodedPublicKey));
        System.out.println(convertToPrivateKey(encodedPrivate));
        String token = generateJwtToken(publicKey, privateKey);
        System.out.println("TOKEN:");
        System.out.println(token);
        printStructure(token, publicKey, privateKey);
    }

    public static String generateJwtToken(ECPublicKey publickey, ECPrivateKey privateKey) throws IOException {
        ECKey key = (ECKey) readPublicKeyFromFile(path, "EC");
        String token = JWT.create()
                .withIssuer("adam")
                .withClaim("Date", new Date(2018, 1, 1))
                .withClaim("email", "info@wstutorial.com")
                .sign(Algorithm.ECDSA256(key));
        return token;
    }

    //Print structure of JWT
    public static void printStructure(String token, ECPublicKey publicKey, ECPrivateKey privatekey) {
        JWTVerifier verifier = JWT.require(Algorithm.ECDSA256(publicKey, null))
                .withIssuer("adam")
                .build();
        DecodedJWT parseClaimsJws = verifier.verify(token);
        System.out.println("");
        System.out.println("Header     : " + parseClaimsJws.getHeader());
        System.out.println("Body       : " + parseClaimsJws.getPayload());
        System.out.println("Signature  : " + parseClaimsJws.getSignature());
        System.out.println("Claims : " + parseClaimsJws.getClaim("email").asString());
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

