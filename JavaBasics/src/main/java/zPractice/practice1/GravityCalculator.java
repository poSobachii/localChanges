package zPractice.practice1;

public class GravityCalculator {
    static final double GRAVITY = -9.81;

    public static void main(String[] args) {
        int fallingTime = args.length > 0 ? Integer.parseInt(args[0]) : 0;
        double initialPosition = args.length > 1 ? Double.parseDouble(args[1]) : 0;
        double initialVelocity = args.length > 2 ? Double.parseDouble(args[2]) : 0;

        double finalPosition = calculateFinalPosition(fallingTime, initialVelocity, initialPosition);

        System.out.println("Position in " + fallingTime + " seconds: " + finalPosition);
    }

    private static double calculateFinalPosition(int t, double v0, double x0){
        return ((t ^ 2) * 0.5 * GRAVITY) + v0 * t + x0;
    }
}
