package u001Usefull;

public class DoWhile {

    public static void main(String[] args) {
        doWhile();
    }

    private static void doWhile(){
        int x = 0;
        while (x < 10) {
            if(x == 5 ){
                x++;
                continue;
            }
            System.out.println("x = " + x );
            x++;
        }
    }
}
