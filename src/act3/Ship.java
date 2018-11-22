package act3;

import act2.Road;
import act2.Transport;

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
