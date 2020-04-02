package a31_exception_handling;

public class ThrowsExcep {

    public static void main(String args[]) {
        NPEcrashProgram();
//        NPEcrashWithTry();
//        finallyOperatorWithoutException();
//        finallyOperatorWithException();
//        multipleExceptionSingleBlock();
//        multipleExceptionSeparateBlocks();
//        catchExceptionFromAnotherMethod();
//        creatingAndCatchingCustomException();
    }

    static void NPEcrashProgram() {
        String str = null;
        System.out.println(str.length());
        System.out.println("До этого кода программа никогда не дойдет");
    }

    static void NPEcrashWithTry() {
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Здесь мы поймали exception и положили его в переменную e " + e);
        }
        System.out.println("Как видно програма не упала, и продолжила свой код");
    }

    static void finallyOperatorWithoutException() {
        try {
            System.out.println("Успешный try оператор");
        } catch (NullPointerException e) {
            System.out.println("Здесь мы поймали exception и положили его в переменную e " + e);
        } finally {
            System.out.println("Оператор finally сработал");
        }
    }

    static void finallyOperatorWithException() {
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Здесь мы поймали exception и положили его в переменную e " + e);
        } finally {
            System.out.println("Оператор finally сработал");
        }
    }

    static void multipleExceptionSingleBlock() {
        for (int i = 0; i < 2; i++) {
            try {
                if(i==0) {
                    String str = null;
                    System.out.println("Спровоцируем NPE exception");
                    System.out.println(str.length());
                } else {
                    System.out.println("Спровоцируем арифметический exception");
                    int number = 10 / 0;
                }
            } catch (NullPointerException | ArithmeticException e) {
                System.out.println("Мы ловим exception в одном блоке: " + e);
            }
        }
    }

    static void multipleExceptionSeparateBlocks() {
        for (int i = 0; i < 2; i++) {
            try {
                if(i==0) {
                    String str = null;
                    System.out.println("Спровоцируем NPE exception");
                    System.out.println(str.length());
                } else {
                    System.out.println("Спровоцируем арифметический exception");
                    int number = 10 / 0;
                }
            } catch (NullPointerException e) {
                System.out.println("Здесь действие будет при NPE: " + e);
            } catch (ArithmeticException e){
                System.out.println("Тут же при арифметическом: " + e);
            }
        }
    }

    static  void catchExceptionFromAnotherMethod(){
        try {
            System.out.println("Попробуем вызвать метод который должен кинуть ошибку:");
            int result = methodThrowsException();
        } catch (ArithmeticException e){
            System.out.println("Мы поймали exception который кинул другой метод командой throws.. " + e);
        }
    }

    static int methodThrowsException() throws ArithmeticException{
        return 10/0;
    }

    static void creatingAndCatchingCustomException(){
        System.out.println("Выводем метод который должен кинуть какой то custom exception");
        try {
            System.out.println("Попытаемся словить наш же custom exception");
            methodThrowsCustomException();
        } catch (SomeCustomException e) {
            System.out.println("Мы его поймали с сообщением -> " + e);
        }
        System.out.println("Как видно программа не упала и продолжает работать после успешного catch");
        System.out.println("Если же он будет не в блоке try/catch, то как и прилюбом unhandled exception, программа просто выкинет ошибку и перестанет работать ");
        methodThrowsCustomException();
    }

    static void methodThrowsCustomException(){
        if (true){
            throw new SomeCustomException("Здесь что то пошло не так и мы вынуждены кинуть exception");
        }

    }
}


