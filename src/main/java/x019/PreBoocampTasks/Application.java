package x019.PreBoocampTasks;

public class Application {

    private final String owner;

    public Application(String name) {
        this.owner = name;
    }

    public static void main(String[] args) {
        String me = "Alex";
        Application app = new Application(me);
        System.out.println("Hello " + app.getOwner());


    }

    public String getOwner() {
        return owner;
    }

}
