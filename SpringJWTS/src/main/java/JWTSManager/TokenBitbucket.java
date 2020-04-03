package JWTSManager;

import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwe.ContentEncryptionAlgorithmIdentifiers;
import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;
import org.jose4j.keys.AesKey;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.JoseException;

import java.security.Key;

public class TokenBitbucket {

    public static String tokenString = "eyJhbGciOiJBMTI4S1ciLCJlbmMiOiJBMTI4Q0JDLUhTMjU2In0" +
            ".YtMyAJDqwmSQ576QsAQvEvAOfTH20e7EMF3E7xZ_ldT7nNvKUC71zQ" +
            ".7NfEhvqit0K4APPNoHAjZw.KVspXG9XmuALDTyyKAWkjQ" +
            ".Q7e4GsIcKTOMV9IWoAVxUQ";

    public static void main(String[] args) throws JoseException {
        Key key = new AesKey(ByteUtil.randomBytes(16));
        System.out.println("Key:" + key.toString());

        String token = encode(key);
        decode(key, token);

    }

    public static String encode(Key key) throws JoseException {
        JsonWebEncryption jwe = new JsonWebEncryption();
        jwe.setPayload("Hello World!");
        jwe.setAlgorithmHeaderValue(KeyManagementAlgorithmIdentifiers.A128KW);
        jwe.setEncryptionMethodHeaderParameter(ContentEncryptionAlgorithmIdentifiers.AES_128_CBC_HMAC_SHA_256);
        jwe.setKey(key);
        String serializedJwe = jwe.getCompactSerialization();
        System.out.println("Serialized Encrypted JWE: " + serializedJwe);
        return serializedJwe;
    }

    public static void decode(Key key, String token) throws JoseException {
        JsonWebEncryption jwe = new JsonWebEncryption();
        jwe.setAlgorithmConstraints(new AlgorithmConstraints(AlgorithmConstraints.ConstraintType.WHITELIST,
                KeyManagementAlgorithmIdentifiers.A128KW));
        jwe.setContentEncryptionAlgorithmConstraints(new AlgorithmConstraints(AlgorithmConstraints.ConstraintType.WHITELIST,
                ContentEncryptionAlgorithmIdentifiers.AES_128_CBC_HMAC_SHA_256));
        jwe.setKey(key);
        jwe.setCompactSerialization(token);
        System.out.println("Payload: " + jwe.getPayload().toString());
    }

//    public static void test() throws JoseException {
//        Key key = new AesKey(ByteUtil.randomBytes(16));
//        JsonWebEncryption jwe = new JsonWebEncryption();
//        jwe.setPayload("Hello World!");
//        jwe.setAlgorithmHeaderValue(KeyManagementAlgorithmIdentifiers.A128KW);
//        jwe.setEncryptionMethodHeaderParameter(ContentEncryptionAlgorithmIdentifiers.AES_128_CBC_HMAC_SHA_256);
//        jwe.setKey(key);
//        String serializedJwe = jwe.getCompactSerialization();
//        System.out.println("Serialized Encrypted JWE: " + serializedJwe);
//
//        jwe = new JsonWebEncryption();
//        jwe.setAlgorithmConstraints(new AlgorithmConstraints(AlgorithmConstraints.ConstraintType.WHITELIST,
//                KeyManagementAlgorithmIdentifiers.A128KW));
//        jwe.setContentEncryptionAlgorithmConstraints(new AlgorithmConstraints(AlgorithmConstraints.ConstraintType.WHITELIST,
//                ContentEncryptionAlgorithmIdentifiers.AES_128_CBC_HMAC_SHA_256));
//        jwe.setKey(key);
//        jwe.setCompactSerialization(serializedJwe);
//        System.out.println("Payload: " + jwe.getPayload());
//    }

}
