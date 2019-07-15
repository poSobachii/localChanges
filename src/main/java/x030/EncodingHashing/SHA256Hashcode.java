package x030.EncodingHashing;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.apache.commons.codec.binary.Hex.encodeHex;

public class SHA256Hashcode {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String temp = "Hello world";
        System.out.println("THe SHA-256 Hashcode will be: " + encode(temp));
        System.out.println("THe SHA-256 Hashcode #2 will be: " + encodeDouble(temp));
    }

    public static String encode(String input) throws NoSuchAlgorithmException {
        StringBuilder builder = new StringBuilder();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

        for (int i = 0; i < encodedhash.length; i++) {
            String hex = Integer.toHexString(0xff & encodedhash[i]);
            if (hex.length() == 1) builder.append('0');
            builder.append(hex);
        }
        return builder.toString();
    }

    public static String encodeDouble(String input) {
        StringBuilder builder = new StringBuilder();
        String result = "shit happens";
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(builder.toString().getBytes(UTF_8));
            digest.update(input.getBytes(UTF_8));
            result = new String(encodeHex(digest.digest()));
            decoding(digest.digest());
            digest.reset();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error: " + e);
        }
        return result;
    }


    public static void decoding(byte[] input) {
        System.out.println("the bytes are: ");
        for (byte b : input) {
            System.out.print(b + ", ");
        }
        System.out.println("");
    }
}
