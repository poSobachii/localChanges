package a71_lambda;


public class NumericExample {
    public static void main(String args[]) {
        NumericTest isEven = (n) -> (n % 2) == 0;
        NumericTest isNegative = (n) -> (n < 0);
        NumericTest2 summ = (n, y) -> (n + y);

        // Output: false
        System.out.println(isEven.computeTest(5));

        // Output: true
        System.out.println(isNegative.computeTest(-5));

        System.out.println(summ.mathemathical(2, 3));
    }
}

interface NumericTest {
    boolean computeTest(int n);
}

interface NumericTest2{
    int mathemathical(int n, int y);
}
