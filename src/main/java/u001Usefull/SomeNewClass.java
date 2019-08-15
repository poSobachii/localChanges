package u001Usefull;

public class SomeNewClass {

    public static void main(String[] args) {

        SomeOtherClass yo = new SomeOtherClass();
        System.out.println(yo.returnsm());
    }
}



class SomeOtherClass{

    public String returnsm(){
        return this.getClass().getSimpleName();
    }

}