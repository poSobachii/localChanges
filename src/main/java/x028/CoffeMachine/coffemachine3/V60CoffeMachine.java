package x028.CoffeMachine.coffemachine3;

/**
 *
 */
public class V60CoffeMachine implements CoffeeMachine {

    private Boolean isBusy;

    @Override
    public Drink make(DrinkOrder_old drinkOrderOld) throws InterruptedException {
        isBusy = true;

        return null;
    }

    @Override
    public boolean validateOrder(String validate) {
        return false;
    }

    @Override
    public String inStock(String ingredients) {
        return null;
    }

    @Override
    public boolean isBusy() throws InterruptedException {
        return isBusy;
    }
}
