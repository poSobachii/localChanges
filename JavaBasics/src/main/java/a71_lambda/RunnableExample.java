package a71_lambda;

public class RunnableExample {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world one!");
            }
        };
        Runnable r2 = () -> System.out.println("Hello world two!");

        r1.run();
        r2.run();
    }
}
