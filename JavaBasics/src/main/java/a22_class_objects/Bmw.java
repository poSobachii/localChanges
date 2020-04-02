package a22_class_objects;

public class Bmw implements Car{
    public String name = "Bmw e60";
    public String color = "red";
    public int price = 30000;
    private String type = "sedan";
    private int motor;

    public Bmw() {
    }

    public Bmw(String name, String color, int price) {
        this.name = name;
        this.color = color;
        this.price = price;
    }

    public Bmw(String name, String color, int price, String type, int motor) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.type = type;
        this.motor = motor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMotor() {
        return motor;
    }

    public void driveon(){

    }

    public void setMotor(int motor) {
        this.motor = motor;
    }

    @Override
    public String drive() {
        return "im driving";
    }

    @Override
    public String engineOn() {
        return "The engine is on";
    }

    @Override
    public int speed() {
        return 150;
    }
}
