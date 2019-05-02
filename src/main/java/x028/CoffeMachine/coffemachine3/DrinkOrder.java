package x028.CoffeMachine.coffemachine3;

public class DrinkOrder {
    private Drink drinkType;
    private double money;
    private int sugar;

    public DrinkOrder() {}

    public DrinkOrder(Drink drinkType) {
        this.drinkType = drinkType;
    }

    public Drink getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(Drink drinkType) {
        this.drinkType = drinkType;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }
}
