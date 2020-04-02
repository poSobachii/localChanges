package a23_OOP.animalTypes;

import a23_OOP.animaLinterface.Animal;

public class Zebra implements Animal, Cloneable {

    private String name = "African.Zebra";
    private String skinColor = "black & white";


    private int currentAge = 12;
    private int activityEnergy = 8;

    public Zebra(){}

    public Zebra(String name, String skinColor){
        this.name = name;
        this.skinColor = skinColor;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Zebra(name, skinColor);
    }

    @Override
    public String toString() {
        return "herbivore.HorseClass{" +
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
        System.out.println("Zebra is eating. Energy left until sleep: " + activityEnergy);
    }

    @Override
    public void run() {
        activityEnergy-=3;
        System.out.println("Zebra is running. Energy left until sleep: " + activityEnergy);
    }

    @Override
    public void sleep() {
        activityEnergy+=10;
        System.out.println("Zebra is sleeping. Energy replenished: " + activityEnergy);
    }

    @Override
    public void play() {
        activityEnergy-=3;
        System.out.println("Zebra is playing. Energy left until sleep: " + activityEnergy);
    }
}
