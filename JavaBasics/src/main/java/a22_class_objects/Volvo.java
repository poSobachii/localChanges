package a22_class_objects;

public class Volvo extends Engine {

    nestedclass neclas = new nestedclass();

    @Override
    String turnoff() {
        return "turning off engine";
    }

    static class nestedclass{

    }
}
