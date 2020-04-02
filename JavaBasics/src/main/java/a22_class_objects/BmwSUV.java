package a22_class_objects;

public class BmwSUV extends Bmw {

    String name = "this is a jeep";
    public int age;

    public BmwSUV() {
    }

    public BmwSUV(String name, String color, int price, int age) {
        super(name, color, price);
        this.age = age;
    }

    @Override
    public String toString() {
        return "This object has these values: " + name + color;
    }
}
