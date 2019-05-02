package x028.CoffeMachine.coffemachine3;


import java.util.List;
import java.util.concurrent.TimeUnit;

import static x028.CoffeMachine.coffemachine3.DrinkType.drinkList;
import static x028.CoffeMachine.coffemachine3.Ingridient.ingridientList;

public class DrinkOrder_old implements CoffeeMachine{
	   private Drink drinkType;
	   private String name;
	   private double money;
	   private int sugar;


		public DrinkOrder_old(String name, double money, int sugar) throws InterruptedException {
			drinkType = new DrinkType(name);
			this.name = name;
			this.money = money;
			this.sugar = sugar;
			DrinkOrder_old.this.make(this);
		}

	@Override
	public Drink make(DrinkOrder_old drinkOrderOld) throws InterruptedException {
		for (DrinkType r : drinkList) {
			if (r.getName().equals(name)){
				if(inStock(name) == "OK"){
					if (validateOrder(name)){
						if(DrinkOrder_old.this.isBusy()){
							System.out.println("Your " + name + " have been prepared ! Please enjoy it ! \n");
							return drinkType;
						}
					}
				}
			}
		}
		return null;
	}

	@Override
	public boolean validateOrder(String validate) {
		double answer = money;
		double price = 0;
		String tempname;
		for (DrinkType d : drinkList) {
			tempname = d.getName();
			if (tempname.equals(name)) {
				price = d.Price();
			}
		}
			if (price == answer) {
				return true;
			} else if (price < answer) {
				System.out.printf("%s - $%.2f" + "\n", "You've inserted to much coins ! here is your change", (answer - price));
				return true;
			} else {
				System.out.println("Not enough money. Sorry :(" + "\n");
				return false;
			}
		}


	@Override
	public String inStock(String ingredients) {
		for (DrinkType d : drinkList) {
			if (d.getName().equals(ingredients)) {
				List<String> recipe = d.getRecipe();
				for (String s : recipe) {
					for (Ingridient ingr : ingridientList) {
						if (ingr.getIngridientName().equals(s) && ingr.getStock() == 0) {
							System.out.println("Sorry but there is no more " + ingredients + " :(" + "\n");
							return "NO";
						}
					}
				}
			}

		} return "OK";
	}

	@Override
	public boolean isBusy() throws InterruptedException {
		int delay = 1;
		System.out.println("Your " + name + " is preparing...");
		TimeUnit.SECONDS.sleep(delay);
//		System.out.println("..adding Ingridients....");
//		TimeUnit.SECONDS.sleep(delay);
//		System.out.println("......adding Water......");
//		TimeUnit.SECONDS.sleep(delay);
//		System.out.println("........Heating it up...");
//		TimeUnit.SECONDS.sleep(delay);
//		System.out.println("...........adding Milk..");
//		TimeUnit.SECONDS.sleep(delay);
		return true;
	}
}
