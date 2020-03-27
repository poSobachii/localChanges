public class TsiExample2 {
//    public static void main(String[] args) {
//         pleasePrintUsSomeText("Janis");
//    }
//
//    static void pleasePrintUsSomeText(String inputText){
//        System.out.println("hello " + inputText
//                + " age " + pleaseTellMeTheAge());
//
//    }
//
//    static Integer pleaseTellMeTheAge() throws NullPointerException{
//        return 30;
//    }

    public static void main(String[] args) {
        pleasePrintSmth("Janis", 27);
    }

    static void pleasePrintSmth(String inputString, int InputAge){
        String newstr = pleaseReturnSomeString();
        System.out.println("Hello: " + newstr);
    }

    static String pleaseReturnSomeString(){

        if ( false){
            return "Olga";
        } else {
            return "Karlis";
        }
    }
}
