package x030.EncodingHashing;

public class ByteEncoding {

    public static void main(String[] args) {
        String temp = "Hello world";
        byte [] bytes = temp.getBytes();
        System.out.println("HW in bytes - "  + bytes);
        for ( byte r : bytes ) {
            System.out.print(r + ", ");
        }
        System.out.println("");
        String hw = new String(bytes);
        System.out.println("HW in text again: - " + hw);

        byte [] fromTranslator = {97, 98, 99, 66};
        byte [] fromTranslator2 = {66, 67, 52, 50, 55, 68, 57, 52, 55, 49, 47, 114, 101, 106, 101, 99, 116, 101,
                100, 38, 48, 51, 38, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49,
                49, 38, 67, 52, 50, 55, 68, 57, 52, 55, 49, 47, 99, 97, 110, 99, 101, 108, 108, 101, 100, 38};
        byte [] hwbites = {72, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100};
        byte [] hwbites2 = {100, -20, -120, -54, 0, -78, 104, -27, -70, 26, 53, 103, -118, 27, 83, 22, -46, 18, -12, -13, 102, -78, 71, 114, 50, 83, 74, -118, -20, -93, 127, 60};

        System.out.println("from google : " + new String(fromTranslator));
        System.out.println("from google : " + new String(fromTranslator2));
        System.out.println("hello world in bytes ? : " + new String(hwbites));
        System.out.println("hello world in bytes ? : " + new String(hwbites2));
    }
}
