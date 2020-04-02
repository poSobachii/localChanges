package a23_OOP.animalLifecycle;


import a23_OOP.animaLinterface.Animal;

public class Play implements Command {

    private Animal animal;
    public Play(Animal animal){
        this.animal = animal;
    }
    @Override
    public void execute() {
        animal.play();
    }
}
