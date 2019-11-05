package RSAKeys;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;
import java.util.UUID;

public class GeneratePublicFromPrivate {


    public static void main(String[] args) throws JOSEException, InvalidKeySpecException, NoSuchAlgorithmException {
        RSAKey jwk = new RSAKeyGenerator(2048)
                .keyUse(KeyUse.SIGNATURE) // indicate the intended use of the key
                .keyID(UUID.randomUUID().toString()) // give the key a unique ID
                .generate();
        String encodedPublicKey = Base64.getEncoder().encodeToString(jwk.toPublicKey().getEncoded());
        String encodedPrivate = Base64.getEncoder().encodeToString(jwk.toPrivateKey().getEncoded());
        System.out.println("\nPUBLIC=" + encodedPublicKey);
        System.out.println("\nPRIVATE=" + encodedPrivate);

        RSAPrivateCrtKey pvt = (RSAPrivateCrtKey) jwk.toPrivateKey();
        RSAPublicKeySpec publicKeySpec = new java.security.spec.RSAPublicKeySpec(pvt.getModulus(), pvt.getPublicExponent());
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey myPublicKey = keyFactory.generatePublic(publicKeySpec);

        System.out.println("\nNEW PUBLIC=" + Base64.getEncoder().encodeToString(myPublicKey.getEncoded()));

    }
}
