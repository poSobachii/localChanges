package a23_OOP.animalTypes;

import a23_OOP.animaLinterface.Animal;

public class Elephant implements Animal, Cloneable {

    private String name = "African.Elephant";
    private String skinColor = "dark Gray";


    private int currentAge = 25;
    private int activityEnergy = 6;

    public Elephant(){}

    public Elephant(String name, String skinColor){
        this.name = name;
        this.skinColor = skinColor;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Elephant(name, skinColor);
    }

    @Override
    public String toString() {
        return "herbivore.Elephant{" +
                "name='" + name + '\'' +
                ", skin color='" + skinColor + '\'' +
                '}';
    }

    @Override
    public String getKind() {
        return name;
    }

    @Override
    public String getColoring() {
        return skinColor;
    }

    @Override
    public int getAge() {
        return currentAge;
    }

    @Override
    public void eat() {
        activityEnergy-=2;
        System.out.println("Elephant is eating. Energy left until sleep: " + activityEnergy);
    }

    @Override
    public void run() {
        activityEnergy-=2;
        System.out.println("Elephant is running. Energy left until sleep: " + activityEnergy);
    }

    @Override
    public void sleep() {
        activityEnergy+=7;
        System.out.println("Elephant is sleeping. Energy replenished: " + activityEnergy);
    }

    @Override
    public void play() {
        activityEnergy-=2;
        System.out.println("Elephant is playing. Energy left until sleep: " + activityEnergy);
    }
}
