package a71_lambda;

public class GenericExample {
    public static void main(String args[]){

        // String version of MyGenericInteface
        MyGeneric<String> reverse = (str) -> {
            String result = "";

            for(int i = str.length()-1; i >= 0; i--)
                result += str.charAt(i);

            return result;
        };

        // Integer version of MyGeneric
        MyGeneric<Integer> factorial = (Integer n) -> {
            int result = 1;

            for(int i=1; i <= n; i++)
                result = i * result;

            return result;
        };

        System.out.println(reverse.compute("Lambda Demo"));
        System.out.println(factorial.compute(5));
    }
}

interface MyGeneric<T> {
    T compute(T t);
}

