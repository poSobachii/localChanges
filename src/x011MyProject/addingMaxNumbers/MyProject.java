package x011MyProject.addingMaxNumbers;

import java.util.*;
import java.util.Scanner;

public class MyProject {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        List<Double> into = new ArrayList<>();
        Double x;

        do {
            System.out.println("Введите число или 000 для продолжения ");
            x = answer();
            if (x != 000) {
                into.add(x);
            } else {
                break;
            }

        } while (true);

        System.out.println(into);
        into.sort(Comparator.reverseOrder());
        System.out.println(into);

        System.out.println("Сколько чисел считать ?");
        Integer y;
        y = scan.nextInt();
        Double summ = 0.0;


        for (int i = 0; i < y; i++) {
            summ += into.get(i);
        }
        System.out.println(summ);

//        double A = 0;
//        double B = 0;
//        for (Double n : into) {
//            if (A < n) {
//                B = A;
//                A = n;
//            } else if (B < n) {
//                B = n;
//            }
//        }
//        System.out.println(A + B);
    }

    private static Double answer() {
        Double answ;
        do {
            try {
                answ = scan.nextDouble();
                return answ;
            } catch (InputMismatchException k) {
                System.out.println("Введите числовое значение.");
                scan.next();

            }
        } while (true);
    }
}