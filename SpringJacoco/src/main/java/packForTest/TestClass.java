package packForTest;

public class TestClass {

    public static void main(String[] args) {
        System.out.println(methodOne());
        System.out.println(methodTwo());
        System.out.println(methodThree());
        System.out.println(methodFour());
    }

    public static String methodOne(){
        return "Four";
    }

    public static String methodTwo(){
        return "Three";
    }

    public static String methodThree(){
        return "Two";
    }

    public static String methodFour(){
        return "One";
    }
}
