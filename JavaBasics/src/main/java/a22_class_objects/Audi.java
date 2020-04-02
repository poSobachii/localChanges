package a22_class_objects;

public class Audi implements Car {

    public String name = engine;
    public String color = "black";

    public Audi() {
    }

    public Audi(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String drive() {
        return null;
    }

    @Override
    public String engineOn() {
        return "The engine is off";
    }

    @Override
    public int speed() {
        return 0;
    }
}
