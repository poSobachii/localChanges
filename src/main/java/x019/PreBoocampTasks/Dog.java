package x019.PreBoocampTasks;

public class Dog implements Animal {

    @Override
    public void eat() {
        System.out.println("eat meat");
    }

    @Override
    public void sleep() {
        System.out.println("sleep in dog house");
    }

    @Override
    public void sit() {
        System.out.println("sit all around");
    }
}
