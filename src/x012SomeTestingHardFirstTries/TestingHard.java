package x012SomeTestingHardFirstTries;

public class TestingHard {

    public static void main(String args[]) {
        int a = 10;
        int b = 20;
        int c = 25;
        int d = 25;
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("b / a = " + (b / a));
        System.out.println("b % a = " + (b % a));
        System.out.println("c % a = " + (c % a));
        System.out.println("a++   = " +  (a++));
        System.out.println("b--   = " +  (a--));
        // Проверьте разницу в d++ и ++d
        System.out.println("d++   = " +  (d++));
        System.out.println("++d   = " +  (++d));
        System.out.println("a == b = " + (a == b) );
        System.out.println("a != b = " + (a != b) );
        System.out.println("a > b = " + (a > b) );
        System.out.println("a < b = " + (a < b) );
        System.out.println("b >= a = " + (b >= a) );
        System.out.println("b <= a = " + (b <= a) );
    }
}

//public class TestingHard {
//
//    public static void main(String args[]) {
//        int a = 60;	/* 60 = 0011 1100 */
//        int b = 13;	/* 13 = 0000 1101 */
//        int c = 0;
//
//        c = a & b;       /* 12 = 0000 1100 */
//        System.out.println("a & b = " + c );
//
//        c = a | b;       /* 61 = 0011 1101 */
//        System.out.println("a | b = " + c );
//
//        c = a ^ b;       /* 49 = 0011 0001 */
//        System.out.println("a ^ b = " + c );
//
//        c = ~a;          /*-61 = 1100 0011 */
//        System.out.println("~a = " + c );
//
//        c = a << 2;     /* 240 = 1111 0000 */
//        System.out.println("a << 2 = " + c );
//
//        c = a >> 2;     /* 215 = 1111 */
//        System.out.println("a >> 2  = " + c );
//
//        c = a >>> 2;     /* 215 = 0000 1111 */
//        System.out.println("a >>> 2 = " + c );
//    }
//}

//public class TestingHard {
//
//    public static void main(String args[]) {
//        int a = 60;	/* 60 = 0011 1100 */
//        int b = 13;	/* 13 = 0000 1101 */
//        int c = 0;
//
//        c = a & b;       /* 12 = 0000 1100 */
//        System.out.println("a & b = " + c );
//
//        c = a | b;       /* 61 = 0011 1101 */
//        System.out.println("a | b = " + c );
//
//        c = a ^ b;       /* 49 = 0011 0001 */
//        System.out.println("a ^ b = " + c );
//
//        c = ~a;          /*-61 = 1100 0011 */
//        System.out.println("~a = " + c );
//
//        c = a << 2;     /* 240 = 1111 0000 */
//        System.out.println("a << 2 = " + c );
//
//        c = a >> 2;     /* 215 = 1111 */
//        System.out.println("a >> 2  = " + c );
//
//        c = a >>> 2;     /* 215 = 0000 1111 */
//        System.out.println("a >>> 2 = " + c );
//    }
//}

//public class TestingHard {
//
//    public static void main(String args[]) {
//        boolean a = false;
//        boolean b = false;
//
//        System.out.println("a && b = " + (a&&b));
//
//        System.out.println("a || b = " + (a||b) );
//
//        System.out.println("!(a && b) = " + !(a && b));
//    }
//}

//public class TestingHard {
//
//    public static void main(String args[]) {
//        int a = 10;
//        int b = 20;
//        int c = 0;
//
//        c = a + b;
//        System.out.println("c = a + b = " + c );
//
//        c += a ;
//        System.out.println("c += a  = " + c );
//
//        c -= a ;
//        System.out.println("c -= a = " + c );
//
//        c *= a ;
//        System.out.println("c *= a = " + c );
//
//        a = 10;
//        c = 15;
//        c /= a ;
//        System.out.println("c /= a = " + c );
//
//        a = 10;
//        c = 15;
//        c %= a ;
//        System.out.println("c %= a  = " + c );
//
//        c <<= 2 ;
//        System.out.println("c <<= 2 = " + c );
//
//        c >>= 2 ;
//        System.out.println("c >>= 2 = " + c );
//
//        c >>= 2 ;
//        System.out.println("c >>= a = " + c );
//
//        c &= a ;
//        System.out.println("c &= 2  = " + c );
//
//        c ^= a ;
//        System.out.println("c ^= a   = " + c );
//
//        c |= a ;
//        System.out.println("c |= a   = " + c );
//    }
//}

//public class TestingHard {
//
//    public static void main(String args[]){
//        int a , b;
//        a = 10;
//        b = (a == 1) ? 20 : 30;
//        System.out.println( "Значение b: " +  b );
//
//        b = (a == 10) ? 20 : 30;
//        System.out.println( "Значение b: " + b );
//    }
//}

//public class TestingHard{
//
//    public static void main(String args[]){
//        String name = "Олег";
//        // Следующее вернётся верно, поскольку тип String
//        boolean result = name instanceof String;
//        System.out.println( result );
//    }
//}

//class Vehicle {}     //нужно много переименовывать чтобы сработал этот код
//
//public class Car extends Vehicle {
//    public static void main(String args[]){
//        Vehicle a = new Car();
//        boolean result =  a instanceof Car;
//        System.out.println( result );
//    }
//}