package RSAencryption;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jose.crypto.RSAEncrypter;
import com.nimbusds.jose.crypto.bc.BouncyCastleProviderSingleton;
import com.nimbusds.jwt.EncryptedJWT;
import com.nimbusds.jwt.JWTClaimsSet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

public class RSAnimbusExample {

    static Date now = new Date();
    static String token = "eyJlbmMiOiJBMTI4R0NNIiwiYWxnIjoiUlNBLU9BRVAtMjU2In0." +
            "UcM9nhQrcEqC56hIRHIaMtapH6BvXAogdsbawfpznJezxgCqV5uKrwwLGp8psrOtIu2" +
            "FmRd1ZsCyKCPrqy9N34Na8LrO2zyQ4wEZ06Nlk_znNFTmnNWbkojN1cO03wT9N4wCmx" +
            "0u5fnWdr5BoF1Z9QhFak33ytOBzbFgy1yGzpjxVMAPSWbFt6pKU1A-u63hAgN2vAXfj" +
            "jNjVcGgmIu_6pvE_DPHY_mK0ebDMNbqfj5CiBv1nEQrabOKd4TlM1a7thyPpLjDojR8" +
            "IwpV_cRlmsk8mMBjMQnmXWLOWesXRXa5LsRTbV9pmJX10lqpYltoJ209XkycY5MPqZA" +
            "YQGwciw.uQIM8vyq-GK4CQwo.ppVpbadr3TztkRkGP_7Dd-baWpSNGa5sMsnKtaIXkL" +
            "YdGiel7PLG5ekHtW3Tm2XML9BRk547CbD9FqksRv9qMjGIJa0rynpSV5DizZ7g8vOcV" +
            "Lp0hXJxzC146c8grtsCd1TbkDY9uKI_tS4OqV1n38QMd4kroCd_5l4gSfNpRb_Fc7F4" +
            "HUksQy0Bj3_xXGrWAXMJweHByDPzJ2vBbYfCyG3Epy0vnMN_9M2kG4dLo2a3CcLA07z" +
            "ulsI5dG4zy5jIiycUJg.5aZZrevog8EQEYMeHJk5Cg";

    static RSAPublicKey publicKey;
    static RSAPrivateKey privateKey;

    public static void main(String[] args) throws JOSEException, ParseException, NoSuchAlgorithmException, IOException, InvalidKeySpecException {
        RSAEncryptionFromFile.decodeToken();
        publicKey = RSAEncryptionFromFile.getPublicKey();
        privateKey = RSAEncryptionFromFile.getPrivateKey();
//        nimbusEncode();
//        nimbusDecode();
        nimbusEncodePayload();

    }


    static void nimbusEncode() throws JOSEException {
        JWTClaimsSet jwtClaims = new JWTClaimsSet.Builder()
                .issuer("https://openid.net")
                .subject("alice")
                .audience(Arrays.asList("https://app-one.com", "https://app-two.com"))
                .expirationTime(new Date(now.getTime() + 1000 * 60 * 10)) // expires in 10 minutes
                .notBeforeTime(now)
                .issueTime(now)
                .jwtID(UUID.randomUUID().toString())
                .build();

        System.out.println(jwtClaims.toJSONObject());

        JWEHeader header = new JWEHeader(JWEAlgorithm.RSA_OAEP_256, EncryptionMethod.A128GCM);
        EncryptedJWT jwt = new EncryptedJWT(header, jwtClaims);
        RSAEncrypter encrypter = new RSAEncrypter(publicKey);
        jwt.encrypt(encrypter);
        String jwtString = jwt.serialize();

        System.out.println("Token=" + jwtString);
    }

    static void nimbusDecode() throws ParseException, JOSEException {
        EncryptedJWT jwt;
        RSADecrypter decrypter = new RSADecrypter(privateKey);
        jwt = EncryptedJWT.parse(token);
        jwt.decrypt(decrypter);

        System.out.println(jwt.getJWTClaimsSet().getIssuer());
        System.out.println(jwt.getJWTClaimsSet().getSubject());
        System.out.println(jwt.getJWTClaimsSet().getAudience().size());
        System.out.println(jwt.getJWTClaimsSet().getExpirationTime());
        System.out.println(jwt.getJWTClaimsSet().getNotBeforeTime());
        System.out.println(jwt.getJWTClaimsSet().getIssueTime());
        System.out.println(jwt.getJWTClaimsSet().getJWTID());
    }

    static void nimbusEncodePayload() throws JOSEException {


            JWEAlgorithm jweAlgorithm = JWEAlgorithm.RSA_OAEP_256;
            EncryptionMethod encryptionMethod = EncryptionMethod.A128GCM;
            JWEHeader.Builder headerBuilder = new JWEHeader.Builder(jweAlgorithm, encryptionMethod);

            headerBuilder.keyID("someID");

            JWEHeader header = headerBuilder.build();
            RSAEncrypter encrypter = new RSAEncrypter(publicKey);
//            Provider provider = BouncyCastleProviderSingleton.getInstance();
//            encrypter.getJCAContext().setProvider(BouncyCastleProviderSingleton.getInstance());
            JWEObject jweObject = new JWEObject(header, new Payload("someData"));
            jweObject.encrypt(encrypter);
            System.out.println("token=" + jweObject.serialize());

    }
}

