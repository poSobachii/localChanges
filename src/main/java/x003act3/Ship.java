package x003act3;

import x002act2.Road;
import x002act2.Transport;

public class Ship extends Transport {

    protected byte sails;

    public Ship(String id, byte sails) {
        super(id);
        this.sails = sails;
    }

    @Override
    public String move(Road road) {
        if (road instanceof WaterRoad) {
            return (getId() + " Ship is sailing on " + road.toString() + " with " + sails + " sails");
        } else {
            return ("Cannot sail on " + road.toString());
        }
    }
}
