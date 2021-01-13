package u001Usefull;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

public class NullableNotCheck {

    public static void main(String[] args) {
        Integer integer = returnNullInteger();
        printIt(null);
        dontPrint(integer);
    }

    static void printIt(@NotNull Integer str){
//        assert str != null;
        System.out.println("This was printed - " + str);
    }

    static void dontPrint(@Nullable Integer str){
//        assert str != null;
        System.out.println("This wasnt printed : " + str);
    }

    @Nullable
    static Integer returnNullInteger(){
        @Nullable Integer integer = null ;
        return integer;
    }
}
