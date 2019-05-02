package x028.CoffeMachine.coffemachine3;

public interface CoffeeMachine {
	public Drink make(DrinkOrder_old drinkOrderOld) throws InterruptedException;

	public boolean validateOrder(String validate);
	
	public String inStock(String ingredients);
	
	public boolean isBusy() throws InterruptedException;
}
