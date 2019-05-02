package x028.CoffeMachine.coffemachine3;

import java.util.List;

public class Cappucino implements Drink {
    @Override
    public String message() {
        return "Cappucino is ready!";
    }

    @Override
    public double Price() {
        return 5;
    }

    @Override
    public List<String> getIngredients() {
        return null;
    }
}
