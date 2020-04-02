package zPractice.practice1.tsi.animals;

public class Cat implements Animal, Domestic {

    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void sound() {
        System.out.println("Meow");
    }

    @Override
    public void printNames() {

        System.out.println("Cat's name is " + this.name);
    }
}
