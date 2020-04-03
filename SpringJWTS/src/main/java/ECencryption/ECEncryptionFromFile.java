package ECencryption;

import RSAencryption.PemUtils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Date;

public class ECEncryptionFromFile {

    static String publicKeyPath = "JWTS/KeyPair/ECpublicK.pem";
    static String privateKeyPath = "JWTS/KeyPair/ECprivateK.pem";
    static String publicStringedToken;
    static String privateStringedToken;
    static ECPublicKey publicKey;
    static ECPrivateKey privateKey;

    public static void main(String[] args) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {
        publicStringedToken = getPublicToken();
        privateStringedToken = getPrivateToken();
        decodeToken();
        String token = generateJwtToken(publicKey, privateKey);
        System.out.println("Token=" + token);

    }

    public static String getPublicToken() throws IOException {
        StringBuilder stringBuffer = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(publicKeyPath));
        String st;
        while ((st = br.readLine()) != null)
            stringBuffer.append(st);
        String temp = stringBuffer.toString();
        temp = temp.replaceAll("-----BEGIN PUBLIC KEY-----", "");
        temp = temp.replaceAll("-----END PUBLIC KEY-----", "");
        return temp;
    }

    public static String getPrivateToken() throws IOException {
        StringBuilder stringBuffer = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(privateKeyPath));
        String st;
        while ((st = br.readLine()) != null)
            stringBuffer.append(st);
        String temp = stringBuffer.toString();
        temp = temp.replaceAll("-----BEGIN PRIVATE KEY-----", "");
        temp = temp.replaceAll("-----END PRIVATE KEY-----", "");
        return temp;
    }

    public static void decodeToken() throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory kf = KeyFactory.getInstance("EC");

        X509EncodedKeySpec keySpecX509 = new X509EncodedKeySpec(Base64.getDecoder().decode(publicStringedToken));
        publicKey = (ECPublicKey) kf.generatePublic(keySpecX509);

        PKCS8EncodedKeySpec keySpecPKCS8 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateStringedToken));
        privateKey = (ECPrivateKey) kf.generatePrivate(keySpecPKCS8);
    }


    public static String generateJwtToken(ECPublicKey publickey, ECPrivateKey privateKey) {
        String token = JWT.create()
                .withKeyId("payment-staging-2")
                .withIssuer("https://identify.nordea.com")
                .withAudience("vsGhBdS67eNBy1faRUBy")
                .withExpiresAt(new Date())
                .withJWTId("37e3b737-7c78-43f0-ba89-eac56fef2fg2")
                .withSubject("payment-staging-2")
                .sign(Algorithm.ECDSA256(publickey, privateKey));
        return token;
    }
}
