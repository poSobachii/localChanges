package x003act3;

import x002act2.Road;
import x002act2.Transport;

public class Vehicle extends Transport {

    protected int numberOfWheels;

    public Vehicle(String id, float consumption, int tankSize, int wheels) {
        super(id, consumption, tankSize);
        this.numberOfWheels = wheels;
    }

    @Override
    public String move(Road road) {
        if (road instanceof WaterRoad) {
            return "Cannot drive on " + road.toString();
        }
        this.consumeFuel(road);

        return this.getId() + " " + this.getType() + " is driving on "
                + road.toString() + " with " + this.numberOfWheels + " wheels";
    }
}
