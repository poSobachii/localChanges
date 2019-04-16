package x026.BuilderPattern.BuilderPattern_3;

public class ComputerBuilder {

    public static void main(String[] args) {

        //Using builder to get the object in a single line of code and
        //without any inconsistent state or arguments management issues
        Computer comp = new Computer.ComputerBuilder()
                .setHDD("STRING")
                .setBluetoothEnabled(true)
                .setGraphicsCardEnabled(true).build();

        System.out.println(comp);

        Computer comp2 = new Computer.ComputerBuilder()
                .setHDD("STRING2")
                .setBluetoothEnabled(true)
                .setGraphicsCardEnabled(true).build();

        System.out.println(comp2);
    }

}
