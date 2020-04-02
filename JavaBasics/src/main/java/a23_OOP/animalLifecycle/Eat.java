package a23_OOP.animalLifecycle;


import a23_OOP.animaLinterface.Animal;

public class Eat implements Command {

    private Animal animal;
    public Eat(Animal animal){
        this.animal = animal;
    }
    @Override
    public void execute() {
        animal.eat();
    }
}
