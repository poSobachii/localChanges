package x028.CoffeMachine.coffemachine2;

public interface CoffeeMachine {
	public Drink make(DrinkOrder drinkOrder);

	public boolean validateOrder(String validate);
	
	public String inStock(String ingredients);
	
	public boolean isBusy() throws InterruptedException;
}
