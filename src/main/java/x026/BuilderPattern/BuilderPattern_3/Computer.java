package x026.BuilderPattern.BuilderPattern_3;


public class Computer {

    private final String HDD;
    private final String RAM;
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;


    public String getHDD() {
        return HDD;
    }

    public String getRAM() {
        return RAM;
    }

    public boolean isGraphicsCardEnabled() {
        return isGraphicsCardEnabled;
    }

    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    public Computer(ComputerBuilder builder) {
        this.HDD=builder.HDD;
        this.RAM=builder.RAM;
        this.isGraphicsCardEnabled=builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled=builder.isBluetoothEnabled;
    }

    //Builder Class
    static class ComputerBuilder{

        private String HDD;
        private String RAM;
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        ComputerBuilder setHDD(String hdd){

            this.HDD = hdd;
            return this;
        }

        ComputerBuilder setRAM(String ram){

            this.RAM = ram;
            return this;
        }


        ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

         Computer build(){
            return new Computer(this);
        }

    }

    @Override
    public String toString() {
        return "Computer { HDD: " + HDD + " RAM: " + RAM + " Graphics: " + isGraphicsCardEnabled + " Bluetooth: " + isBluetoothEnabled();
    }
}