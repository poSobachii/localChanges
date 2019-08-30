package u001Usefull;

public class ExecptionTestings {

    public static void main(String[] args) {
//        try {
//            System.out.println(generateString());
//        } catch (SomeMinorException e){
//            System.out.println("res=" + e);
//        }
        thowException();
        System.out.println("some");
    }

    static String generateString(){
        boolean fix = false;
        if (fix){
            return "Everything is fine";
        }
        throw new SomeMinorException("error message");
    }

    static void thowException() {
        throw new SomeMinorException("mandatory throw");
    }
}


class SomeMinorException extends RuntimeException{
    public SomeMinorException(String message) {
        super(message);
    }
}