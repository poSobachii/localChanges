package x019.PreBoocampTasks;

public class twoArrays {
    public static void main(String[] args) {
        int num1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int num2[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        printThem(num1);
        printThem(num2);

        for (int i = 0; i < num1.length; i++) {
            num2[i] = num1[i];
        }
        printThem(num1);
        printThem(num2);

        int num3[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i <num1.length; i++) {
            if (num1[i] > 5) {
                num3[i] = num1[i];
            }

        }
        printThem(num1);
        printThem(num2);
        System.out.println("");
        for (int i =0; i < num3.length; i++) {
            if(num3[i] != 0)
            System.out.print(num3[i] + " ");
        }
    }
    public static int [] printThem(int [] num1000) {
        System.out.println("");
        for (int i : num1000) {
            System.out.print(i + " ");
        }
        return num1000;
    }
}





