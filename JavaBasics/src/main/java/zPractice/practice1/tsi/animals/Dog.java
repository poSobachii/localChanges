package zPractice.practice1.tsi.animals;

public class Dog implements Animal, Domestic{

    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void printNames() {
        System.out.println("Dog's name is " + this.name);
    }

    @Override
    public void sound() {
        System.out.println("Bark");
    }
}
