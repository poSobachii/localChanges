package zPractice.practice1.tsi.animals;

public class Animals {
    public static void main(String[] args) {
        Cat cat = new Cat("Dog");
        cat.sound();
        cat.printNames();
        Dog dog = new Dog("Cat");
        dog.sound();
        dog.printNames();
        Fox fox = new Fox();
        fox.sound();
        fox.secretSkill();
    }
}
