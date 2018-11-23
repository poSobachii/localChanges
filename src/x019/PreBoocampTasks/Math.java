package x019.PreBoocampTasks;

public class Math {

    public static void main(String[] args) {
        int x = 0;
        M(x);
    }

    private static int M(int x) {
        System.out.println(x);
        return M(x+1);
    }
}