package x028.CoffeMachine.coffemachine2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static x028.CoffeMachine.coffemachine2.DrinkType.drinkList;

public class Ingridient implements CoffeeMachine{

    private String ingridientName = "";
    private int stock = 0;
    public static List<Ingridient> ingridientList = new ArrayList<Ingridient>();


    public Ingridient(String name){
        this.ingridientName = name;
        this.stock = 2;
        ingridientList.add(this);
    }

    public Ingridient(){

    }

    public String getIngridientName() { return ingridientName; }

    public void setIngridientName(String ingridientName) { this.ingridientName = ingridientName; }

    public int getStock() { return stock; }

    public void setStock(int stock) { this.stock = stock; }


    @Override
    public Drink make(DrinkOrder drinkOrder) {
        return null;
    }

    @Override
    public boolean validateOrder(String validate) {
        for (DrinkType d : drinkList) {
            String tempname = d.getDrinkName();
            if (tempname.equals(validate)) {
                List<String> recipe = d.getRecipe();
                for (String s : recipe) {
                    for (Ingridient ingr : ingridientList) {
                        if (ingr.getIngridientName().equals(s) && ingr.getStock() == 0) {
                            System.out.println("Sorry but there is no more " + validate + " :(" + "\n");
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override
    public String inStock(String ingredients) {
        for (Ingridient d : ingridientList) {
            System.out.printf("%s - amount: %d " + "\n", d.getIngridientName(), d.getStock());
        }
        System.out.println(" ");
        return null;
    }

    @Override
    public boolean isBusy() throws InterruptedException {
        int delay = 1;
        TimeUnit.SECONDS.sleep(delay);
        System.out.println("..adding Ingridients....");
        TimeUnit.SECONDS.sleep(delay);
        System.out.println("......adding Water......");
        TimeUnit.SECONDS.sleep(delay);
        System.out.println("........Heating it up...");
        TimeUnit.SECONDS.sleep(delay);
        System.out.println("...........adding Milk..");
        TimeUnit.SECONDS.sleep(delay);
        return true;
    }
}
