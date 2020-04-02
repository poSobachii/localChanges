package zPractice.practice1;

public class Marathon {

    public static void main(String[] args) {
        String[] names = {"Elena", "Thomas", "Hamilton",
                "Suzie", "Phil", "Matt", "Alex", "Emma",
                "John", "James", "Jane", "Emily",
                "Daniel", "Neda", "Aaron", "Kate"};
        int[] times = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};

        printResults(names, times);

    }

    private static void printResults(String[] names, int[] times) {
        System.out.printf("%-20s %s%n", "Name", "Result");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%-20s %d%n", names[i], times[i]);
        }
    }
}
