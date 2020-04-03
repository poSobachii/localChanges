package JWTSManager;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;

import java.security.interfaces.RSAPublicKey;
import java.util.Base64;
import java.util.UUID;

public class JWKgenerator {

    public static void main(String[] args) throws JOSEException {
        generateJWK();
    }

    public static void generateJWK() throws JOSEException {
        RSAKey jwk = new RSAKeyGenerator(2048)
                .keyUse(KeyUse.SIGNATURE) // indicate the intended use of the key
                .keyID(UUID.randomUUID().toString()) // give the key a unique ID
                .generate();
        System.out.println("JWK=" +jwk + "\n");

        RSAPublicKey rsaPublicKey = (RSAPublicKey) jwk.toPublicKey();
        String encodedPublicKey = Base64.getEncoder().encodeToString(jwk.toPublicKey().getEncoded());
        String encodedPrivate = Base64.getEncoder().encodeToString(jwk.toPrivateKey().getEncoded());
        String encodedPublicUrlKey = Base64.getUrlEncoder().encodeToString(jwk.toPublicKey().getEncoded());

        String some1 = Base64.getUrlEncoder().encodeToString(rsaPublicKey.getModulus().toByteArray());
        String some2 = Base64.getUrlEncoder().encodeToString(rsaPublicKey.getPublicExponent().toByteArray());
        System.out.println("\nPUBLIC=" + encodedPublicKey);
        System.out.println("\nURL=" + encodedPublicUrlKey);
        System.out.println("\nPRIVATE=" + encodedPrivate);
//        System.out.println("\nSome1=" + some1);
//        System.out.println("\nSome2=" + some2);


    }
}
