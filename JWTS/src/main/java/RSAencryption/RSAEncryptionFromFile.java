package RSAencryption;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class RSAEncryptionFromFile {

    static String publicKeyPath = "JWTS/KeyPair/publicK.pem";
    static String privateKeyPath = "JWTS/KeyPair/privateK.pem";
    static String publicStringedToken;
    static String privateStringedToken;
    static RSAPublicKey publicKey;
    static RSAPrivateKey privateKey;

    public static void main(String[] args) throws FileNotFoundException {
        getPublicToken();
        getPrivateToken();

    }

    public static void getPublicToken() throws FileNotFoundException {
        List<String> inputStrings= new ArrayList<>();
        File file = new File(publicKeyPath);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine())
            inputStrings.add(sc.nextLine());
        publicStringedToken = inputStrings.get(1);
    }

    public static void getPrivateToken(){

    }


    public static String generateJwtToken(RSAPublicKey publickey, RSAPrivateKey privateKey) {
        String token = JWT.create()
                .withIssuer("adam")
                .withClaim("Date", new Date(2018, 1, 1))
                .withClaim("email", "info@wstutorial.com")
                .sign(Algorithm.RSA256(publickey, privateKey));
        return token;
    }
}
