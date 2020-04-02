package a23_OOP.animalTypes;

import a23_OOP.animaLinterface.Animal;

public class Tiger implements Animal, Cloneable {

    private String name = "Asian.Tiger";
    private String skinColor = "black & orange";


    private int currentAge = 7;
    private int activityEnergy = 12;

    public Tiger(){}

    public Tiger(String name, String skinColor){
        this.name = name;
        this.skinColor = skinColor;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Tiger(name, skinColor);
    }

    @Override
    public String toString() {
        return "predator.CatClass{" +
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
        System.out.println("Tiger is eating. Energy left until sleep: " + activityEnergy);
    }

    @Override
    public void run() {
        activityEnergy-=3;
        System.out.println("Tiger is running. Energy left until sleep: " + activityEnergy);
    }

    @Override
    public void sleep() {
        activityEnergy+=12;
        System.out.println("Tiger is sleeping. Energy replenished: " + activityEnergy);
    }

    @Override
    public void play() {
        activityEnergy-=3;
        System.out.println("Tiger is playing. Energy left until sleep: " + activityEnergy);
    }
}
