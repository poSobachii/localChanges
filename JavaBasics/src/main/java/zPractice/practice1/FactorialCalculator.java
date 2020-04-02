package zPractice.practice1;

public class FactorialCalculator {
    public static void main(String[] arguments) {
        System.out.println(factorialRecursive(4));
        System.out.println(factorial(4));
    }

    private static int factorial(int n){
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    private static int factorialRecursive(int n){
        if (n <= 1) {
            return 1;
        } else {
            return n * factorialRecursive(n - 1);
        }
    }
}
