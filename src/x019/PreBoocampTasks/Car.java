package x019.PreBoocampTasks;

public class Car extends Abstractcar {
    private String color;
    private String engine;
    private int hp = 85;
    private String type;


    public Car() {

    }

    public Car(String color1){
        color=color;
    }

    public Car(String color, String engine, int hp, String type) {
        this.color = color;
        this.engine = engine;
        this.hp = hp;
        this.type = type;
    }
    public String getInformation(){
        System.out.print("Color: " + color);
        System.out.print(" Engine: " + engine);
        System.out.print(" HorsePower: " + hp);
        System.out.print(" Type: " + type);
        System.out.println("");
        String carInfo = "Color: " + color + ", Engine: " + engine + ", HorsePower: " + hp + ", Type: " + type;

        return carInfo;
    }

    public void driveFW() {
        System.out.println("Drive forward");
    }

    public void driveBW(){
        System.out.println("Drive backward");
    }

    public void stop(){
        System.out.println("STOP !");
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", engine='" + engine + '\'' +
                ", hp=" + hp +
                ", type='" + type + '\'' +
                '}';
    }
}
