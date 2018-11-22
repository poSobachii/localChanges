package act2;

public class Road {
    private String from;
    private String to;
    private int distance;

    public Road(String from, String to, int distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    public Road() {

    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return (from + " — " + to + ", " + distance + "km");
    }

}