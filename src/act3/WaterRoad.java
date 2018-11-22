package act3;

import act2.Road;

public class WaterRoad extends Road {

    public WaterRoad(String from, String to, int distance) {
        super(from, to, distance);

    }

    public WaterRoad () {
        super("", "", 0);
    }

    @Override
    public String toString()  {

        return ("WaterRoad " + getFrom() + " — " + getTo() + ", " + getDistance() + "km");
    }

}

