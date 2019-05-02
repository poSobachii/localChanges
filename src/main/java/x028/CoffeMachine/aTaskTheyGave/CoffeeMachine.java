package x028.CoffeMachine.aTaskTheyGave;

import java.util.List;

public interface CoffeeMachine {
	public Drink make(DrinkOrder drinkOrder);

	public boolean validateOrder(DrinkOrder drinkOrder);

	public boolean inStock(List<String> ingredients);

	public boolean isBusy();
}
