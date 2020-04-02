package zPractice.practice1;

import java.util.Arrays;
import java.util.Random;

public class OneDimensionalArray {
    public static void main(String[] args) {
        double[] array = createRandomArray(20);
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.printf("Min %5.2f%n", array[0]);
        System.out.printf("Max %5.2f%n", array[array.length - 1]);
        System.out.printf("Mean %.2f%n", mean(array));
    }

    private static double[] createRandomArray(int size) {
        assert (size > 0);
        double[] arr = new double[size];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextDouble() * 10; // generates random between 0 (inclusive) and 1 (exclusive)
        }
        return arr;
    }

    private static double mean(double[] arr) {
        double sum = 0;
        for (double value : arr) {
            sum += value;
        }
        return sum / arr.length;
    }
}
