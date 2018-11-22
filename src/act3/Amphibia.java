package act3;

import act2.Road;
import act2.Transport;

public class Amphibia extends Transport {

    private byte sails;
    private int wheels;

    public Amphibia(String id, float consumption, int tankSize,
                    byte sails, int wheels) {
        super(id, consumption, tankSize);
        this.sails = sails;
        this.wheels = wheels;

    }
    @Override
    public String move(Road road) {
        if (road instanceof WaterRoad) {

            return (getId() + " Amphibia is sailing on " + road.toString() + " with " + sails + " sails");
        } else {
            this.consumeFuel(road);
            return (getId() + " Amphibia is driving on " + road.toString() + " with " + wheels + " wheels");
        }
    }

}
