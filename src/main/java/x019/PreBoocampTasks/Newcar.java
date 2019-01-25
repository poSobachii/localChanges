package x019.PreBoocampTasks;

public class Newcar extends Car {

    public Newcar(String color, String engine, int hp, String type) {
        super(color, engine, hp, type);
    }

    @Override
    public void driveBW() {
        System.out.println("Drive bw FASTER!");
    }

    public void driveFW(int speed) {
        System.out.println("You are riding at " + speed);
    }
}
