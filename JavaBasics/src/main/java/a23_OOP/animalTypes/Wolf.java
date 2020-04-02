package a23_OOP.animalTypes;

import a23_OOP.animaLinterface.Animal;

public class Wolf implements Animal, Cloneable {

    private String name = "Siberian.Wolf";
    private String skinColor = "brown & white";


    private int currentAge = 3;
    private int activityEnergy = 12;

    public Wolf(){}

    public Wolf(String name, String skinColor){
        this.name = name;
        this.skinColor = skinColor;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Wolf(name, skinColor);
    }

    @Override
    public String toString() {
        return "predator.DogClass{" +
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
        activityEnergy-=3;
        System.out.println("Wolf is eating. Energy left until sleep: " + activityEnergy);
    }

    @Override
    public void run() {
        activityEnergy-=3;
        System.out.println("Wolf is running. Energy left until sleep: " + activityEnergy);
    }

    @Override
    public void sleep() {
        activityEnergy+=12;
        System.out.println("Wolf is sleeping. Energy replenished: " + activityEnergy);
    }

    @Override
    public void play() {
        activityEnergy-=3;
        System.out.println("Wolf is playing. Energy left until sleep: " + activityEnergy);
    }
}
