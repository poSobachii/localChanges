package FullLogicEncyption;

import RSAencryption.RSAEncryptionFromFile;
import RSAencryption.tokenObjectFormat;
import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jose.crypto.RSAEncrypter;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jwt.EncryptedJWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class FullLogic {

    private static RSAPrivateKey privateKey;
    private static RSAPublicKey publicKey;
    private static String signedToken;
    private static String encryptedToken;

    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException, JOSEException, IOException, ParseException {
        convertKeys();
        generateToken();
        encryptToken();
        decodeToken();
    }


    public static void convertKeys() throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
        RSAEncryptionFromFile.decodeToken();
        publicKey = RSAEncryptionFromFile.getPublicKey();
        privateKey = RSAEncryptionFromFile.getPrivateKey();
    }

    public static void generateToken() throws JOSEException {
        JWTClaimsSet jwtClaims = new JWTClaimsSet.Builder()
                .issuer("someone")
                .subject("alice")
                .audience("someoneAnother")
                .expirationTime(new Date(System.currentTimeMillis()))
                .jwtID(UUID.randomUUID().toString())
                .build();
        JWSSigner signer = new RSASSASigner(privateKey);
        JWSObject jwsObject = new JWSObject(new JWSHeader.Builder(JWSAlgorithm.RS256).keyID("someId").build(), new Payload(jwtClaims.toJSONObject()));
        jwsObject.sign(signer);
        signedToken = jwsObject.serialize();
        System.out.println("signedToken=" + jwsObject.serialize());
    }

    public static void encryptToken() throws JOSEException {
        JWTClaimsSet jwtClaims = new JWTClaimsSet.Builder()
                .issuer("someone")
                .subject("alice")
                .audience("someoneAnother")
                .claim("id_token", signedToken)
                .expirationTime(new Date(System.currentTimeMillis()))
                .jwtID(UUID.randomUUID().toString())
                .build();

        JWEHeader header = new JWEHeader(JWEAlgorithm.RSA_OAEP_256, EncryptionMethod.A128GCM);
        EncryptedJWT jwt = new EncryptedJWT(header, jwtClaims);
        RSAEncrypter encrypter = new RSAEncrypter(publicKey);
        jwt.encrypt(encrypter);
        encryptedToken= jwt.serialize();
        System.out.println("encryptedToken=" + jwt.serialize());
    }

    public static void decodeToken() throws JOSEException, ParseException {
        EncryptedJWT jwt;
        RSADecrypter decrypter = new RSADecrypter(privateKey);
        jwt = EncryptedJWT.parse(encryptedToken);
        jwt.decrypt(decrypter);
        JWTClaimsSet claimsSet = jwt.getJWTClaimsSet();

        SignedJWT nordeaToken = SignedJWT.parse(claimsSet.getClaim("id_token").toString());
        RSASSAVerifier verifier = new RSASSAVerifier(publicKey);
        nordeaToken.verify(verifier);
        System.out.println("payload=" + nordeaToken.getPayload());
    }
}
