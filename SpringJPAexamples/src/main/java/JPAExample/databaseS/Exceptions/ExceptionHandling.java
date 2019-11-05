package JPAExample.databaseS.Exceptions;


public class ExceptionHandling {

    public void printStatus(){
        System.out.println("Exception Handler invoked");
    }

    public String getRuntime(int x){
        switch (x) {
            case 1: return "succeed";
            case 0:  throw new RuntimeExcept("runttime except #1 thrown");
            default: return "no such number";
        }
    }

    public String getOrdinaryException(int x) throws OrdinaryException {
        switch (x) {
            case 1: return "succeed";
            case 0:  throw new OrdinaryException( "regular except #2 thrown");
            default: return "no such number";
        }
    }
}


