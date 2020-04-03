import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class TestError {

    static SecretKey secKey;
    static PrivateKey prKey;
    static PublicKey puKey;
    static byte[] encryptedKey;
    static byte[] decryptedKey;
    static byte[] byteCipherText;
    static Cipher cipher;

    public static void main(String[] args) throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        generateKey();
        encrypt();
        encrypt2();
        decrypt();
        decrypt2();
    }



    static  void  generateKey() throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(128); // The AES key size in number of bits
         secKey = generator.generateKey();
    }

    static void encrypt() throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        String plainText = "Please encrypt me urgently...";
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.ENCRYPT_MODE, secKey);
        byteCipherText = aesCipher.doFinal(plainText.getBytes());
    }

    static void encrypt2() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair keyPair = kpg.generateKeyPair();

         puKey = keyPair.getPublic();
         prKey = keyPair.getPrivate();

        cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.PUBLIC_KEY, puKey);
        encryptedKey = cipher.doFinal(secKey.getEncoded());
    }

    static void decrypt() throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        cipher.init(Cipher.PRIVATE_KEY, prKey);
        decryptedKey = cipher.doFinal(encryptedKey);
    }

    static void decrypt2() throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        SecretKey originalKey = new SecretKeySpec(decryptedKey , 0, decryptedKey .length, "AES");
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.DECRYPT_MODE, originalKey);
        byte[] bytePlainText = aesCipher.doFinal(byteCipherText);
        String plainText = new String(bytePlainText);
        System.out.println(plainText);
    }
}
