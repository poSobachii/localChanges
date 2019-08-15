package u001Usefull;

public class TenaryOperators {

    public static void main(String[] args) {
        methodOne();
        methodDva();
    }

    static void methodOne(){
        int x = 10;
        int y = 5;
        int result = x + y;
        String resultAnswer = (result == 15) ? "ur right" : "nope it's not";
        System.out.println("res1= " + resultAnswer);
        String resultAnswer2 = (result == 16) ? "ur right" : "nope it's not";
        System.out.println("res2= " +resultAnswer2);
    }

    static void methodDva(){
        System.out.println("we pass true = " + returnString( true));
        System.out.println("we pass false = " + returnString( false));
    }

    static String returnString(boolean condition){
        return (condition) ? "true value" : "false value";
    }
}
