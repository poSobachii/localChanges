package RSAencryption;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class RSAEncryptionFromFile {

//    PemUtils pemUtils = new PemUtils();

    static String publicKeyPath = "JWTS/KeyPair/publicK.pem";
    static String privateKeyPath = "JWTS/KeyPair/privateK.pem";
    static String publicStringedToken;
    static String privateStringedToken;
    static RSAPublicKey publicKey;
    static RSAPrivateKey privateKey;

    public static void main(String[] args) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {
        decodeToken();
        String token = generateJwtToken(publicKey, privateKey);
        System.out.println("Token=" + token);

    }

//    public static String getPublicToken() throws FileNotFoundException {
//        List<String> inputStrings= new ArrayList<>();
//        File file = new File(publicKeyPath);
//        Scanner sc = new Scanner(file);
//        while (sc.hasNextLine())
//            inputStrings.add(sc.nextLine());
//        return inputStrings.get(1);
//    }
//    public static void readOnlyOneString() throws IOException {
//        String data = "";
//        data = new String(Files.readAllBytes(Paths.get(privateKeyPath)));
//        System.out.println(data);
//    }

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

    public static void decodeToken() throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
        publicStringedToken = getPublicToken();
        privateStringedToken = getPrivateToken();


        KeyFactory kf = KeyFactory.getInstance("RSA");

        X509EncodedKeySpec keySpecX509 = new X509EncodedKeySpec(Base64.getDecoder().decode(publicStringedToken));
        publicKey = (RSAPublicKey) kf.generatePublic(keySpecX509);

        PKCS8EncodedKeySpec keySpecPKCS8 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateStringedToken));
        privateKey = (RSAPrivateKey) kf.generatePrivate(keySpecPKCS8);
    }


    public static String generateJwtToken(RSAPublicKey publickey, RSAPrivateKey privateKey) {
        String token = JWT.create()
                .withKeyId("payment-staging-2")
                .withIssuer("https://identify.nordea.com")
                .withAudience("vsGhBdS67eNBy1faRUBy")
                .withExpiresAt(new Date(2020, 07, 24))
                .withJWTId(UUID.randomUUID().toString())
                .withSubject("payment-staging-2")
                .sign(Algorithm.RSA256(publickey, privateKey));
        return token;
    }

    public static RSAPublicKey getPublicKey() {
        return publicKey;
    }

    public static RSAPrivateKey getPrivateKey() {
        return privateKey;
    }
}
