package x019.PreBoocampTasks;

public class Program {

    static int computeSize(int height, int width) {
        return height * width;
    }

    public static void main(String[] args) {
        int result = computeSize(10, 3);
        System.out.println(result);
    }
}
