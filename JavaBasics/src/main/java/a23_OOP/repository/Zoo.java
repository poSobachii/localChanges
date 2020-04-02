package a23_OOP.repository;


import a23_OOP.animaLinterface.Animal;

import java.util.ArrayList;
import java.util.List;

public class Zoo implements Animal {

    private List<Animal> animalList = new ArrayList<>();

    public void addAnimal(Animal animal){
        animalList.add(animal);
    }
    public void killAnimal(Animal animal){
        animalList.remove(animal);
    }


    @Override
    public String getKind() {
        StringBuilder builder = new StringBuilder();
        builder.append("Types of animals in zoo: ");
        for (Animal animal: animalList){
            builder.append(animal.getKind() + ", ");
        }
        return builder.toString();
    }

    @Override
    public String getColoring() {
        StringBuilder builder = new StringBuilder();
        builder.append("Total color draft: ");
        for (Animal animal: animalList){
            builder.append(animal.getColoring() + ", ");
        }

        return builder.toString();
    }

    @Override
    public int getAge() {
        int summaryYears = 0;
        for (Animal animal: animalList){
            summaryYears+=animal.getAge();
        }
        return summaryYears;
    }

    @Override
    public void eat() {

    }

    @Override
    public void run() {

    }

    @Override
    public void sleep() {

    }

    @Override
    public void play() {

    }
}
