package u001Usefull;

public class AssertInMethod {

    public static void main(String[] args) {
        int x = getX();
        assert x ==0;
        System.out.println("do smth");
    }

    static int getX(){
        return 1;
    }
}


// this code will work if assertions are enabled ( in configuration VM options = -ea )