package x002act2;

import java.util.Locale;

public class Transport {

    private String id;
    private float consumption;
    private int tankSize;
    private float fuelInTank;

    public Transport(String id, float consumption, int tankSize, float fuelInTank) {
        this.id = id;
        this.consumption = consumption;
        this.tankSize = tankSize;
        this.fuelInTank = fuelInTank;
    }
    public Transport(String id){
        this.id = id;
    }

    public Transport(String id, float consumption, int tankSize){
        this.id = id;
        this.consumption = consumption;
        this.tankSize = tankSize;
        this.fuelInTank = 1.0f * tankSize / 1.0f;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getConsumption() {
        return consumption;
    }

    public void setConsumption(float consumption) {
        this.consumption = consumption;
    }

    public int getTankSize() {
        return tankSize;
    }

    public void setTankSize(int tankSize) {
        this.tankSize = tankSize;
    }

    public float getFuelInTank() {
        return fuelInTank;
    }

    public void setFuelInTank(float fuelInTank) {
        this.fuelInTank = fuelInTank;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "Id:%s cons:%.1fl/100km, tank:%dl, fuel:%.2fl", id, consumption, tankSize, fuelInTank);
    }

    protected final String getType() {
        this.getClass().getSimpleName();
        return this.getClass().getSimpleName();
    }

    public String move(Road road) {
        float req = road.getDistance() * (this.consumption / 100);
        if (this.fuelInTank - req >= 0) {
            fuelInTank = fuelInTank - req;
            return this.getId() + " " +  getType() + " is moving on " + road.toString();

        } else {
            return String.format(Locale.US,
                    "Cannot move on %s. Necessary fuel:%.2fl, fuel in tank:%.2fl",
                    road.toString(), req, fuelInTank);
        }

    }

    public void consumeFuel(Road road) {
        float litresConsumed = (this.getConsumption() / 100)
                * road.getDistance();
        this.setFuelInTank(this.getFuelInTank() - litresConsumed);
    }

}
