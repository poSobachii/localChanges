package RSAencryption;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jwt.EncryptedJWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class WrongKidExample {

    static RSAPublicKey publicKey1;
    static RSAPublicKey publicKey2;
    static RSAPrivateKey privateKey1;
    static RSAPrivateKey privateKey2;
    static String token;


    public static void main(String[] args) throws NoSuchAlgorithmException, JOSEException, ParseException {
        generateKeys();
        generateToken();
//        decodeWithRight();
//        decodeWithWrong();
        decrypt();
    }

    static void generateKeys() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("RSA");
        keyGenerator.initialize(2048);
        KeyPair kp1 = keyGenerator.genKeyPair();
        publicKey1 = (RSAPublicKey) kp1.getPublic();
        privateKey1 = (RSAPrivateKey) kp1.getPrivate();
        KeyPair kp2 = keyGenerator.genKeyPair();
        publicKey2 = (RSAPublicKey) kp2.getPublic();
        privateKey2 = (RSAPrivateKey) kp2.getPrivate();
        System.out.println("pkey1=\n" + Base64.getEncoder().encodeToString(publicKey1.getEncoded()));
        System.out.println("prkey2=\n"  + Base64.getEncoder().encodeToString(privateKey1.getEncoded()));
        System.out.println("pkey1=\n" + Base64.getEncoder().encodeToString(publicKey2.getEncoded()));
        System.out.println("prkey2=\n" + Base64.getEncoder().encodeToString(privateKey2.getEncoded()));
    }


    static void generateToken() throws JOSEException {
        JWTClaimsSet jwtClaims = new JWTClaimsSet.Builder()
                .issuer("bla")
                .audience("bla")
                .subject(UUID.randomUUID().toString())
                .expirationTime(new Date(2019, 07, 24))
                .jwtID(UUID.randomUUID().toString())
                .build();
        JWSSigner signer = new RSASSASigner(privateKey1);
        JWSObject jwsObject = new JWSObject(new JWSHeader.Builder(JWSAlgorithm.RS256).keyID("someId").build(), new Payload(jwtClaims.toJSONObject()));
        jwsObject.sign(signer);

        token = jwsObject.serialize();
        System.out.println("token=\n" + token);
    }

    static void decodeWithRight() throws ParseException, JOSEException {
        RSASSAVerifier verifier = new RSASSAVerifier(publicKey1);
        SignedJWT signedJWT = SignedJWT.parse(token);
        signedJWT.verify(verifier);
        System.out.println("Succesfully verified=\n" + signedJWT.getPayload());
    }

    static void decodeWithWrong() throws ParseException, JOSEException {
        RSASSAVerifier verifier = new RSASSAVerifier(publicKey2);
        SignedJWT signedJWT = SignedJWT.parse(token);
        signedJWT.verify(verifier);
        System.out.println("UnSuccesfully UnVerified=\n" + signedJWT.getPayload());
    }


    static void decrypt(){
        try {
            EncryptedJWT jwt = EncryptedJWT.parse(null);
            RSADecrypter decrypter = new RSADecrypter(privateKey1);
            jwt.decrypt(decrypter);
            System.out.println(jwt.getPayload().toString());
        } catch (ParseException | JOSEException | NullPointerException e) {
            System.out.println("res=" + e);
        }
    }
}
