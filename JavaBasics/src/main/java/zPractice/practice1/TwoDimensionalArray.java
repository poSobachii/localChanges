package zPractice.practice1;

import java.util.Random;

public class TwoDimensionalArray {

    private static int[][] createRandomArray(int size) {
        assert (size > 0);

        int[][] arr = new int[size][size];

        Random random = new Random();
        int upperBound = 100 + 1;

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                arr[row][col] = random.nextInt(upperBound); // generates random between 0 (inclusive) and upper bound (exclusive)
            }
        }

        return arr;
    }

    private static double mean(int[] arr) {
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        return (double) sum / arr.length;
    }

    private static void print(int[][] arr) {
        // print matrix and print mean per row
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.printf("%7d", arr[row][col]);
            }

            System.out.printf("%7.0f%n", mean(arr[row]));
        }

        // print mean per col
        for (int row = 0; row < arr.length; row++) {
            int[] colRow = new int[arr.length];
            for (int col = 0; col < arr[row].length; col++) {
                colRow[col] = arr[col][row];
            }

            System.out.printf("%7.0f", mean(colRow));
        }
    }

    public static void main(String[] args) {
        int[][] array = createRandomArray(10);
        print(array);
    }
}
