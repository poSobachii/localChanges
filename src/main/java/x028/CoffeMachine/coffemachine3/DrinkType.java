package x028.CoffeMachine.coffemachine3;

import java.util.ArrayList;
import java.util.List;


public class DrinkType extends Ingridient implements Drink {

    private String name = "";
    private double cost = 0.00;
    private List<String> recipe;
    public static ArrayList<DrinkType> drinkList = new ArrayList<>();

    public DrinkType(String name, double cost, List<String> recipe){
        this.name = name;
        this.cost = cost;
        this.recipe = recipe;
        drinkList.add(this);
    }
    public DrinkType(){

    }
    public DrinkType(String name){
        for (DrinkType d : drinkList) {
            if (d.getName().equals(name)) {
                List<String> recipe = d.getRecipe();
                for (String s : recipe) {
                    for (Ingridient ingrX : ingridientList) {
                        if (s.equals(ingrX.getIngridientName())) {
                            ingrX.setStock(ingrX.getStock() - 1);
                        }
                    }
                }
            }
        }
    }

    @Override
    public String message() {
        int count = 1;
        for (DrinkType d : drinkList) {
            System.out.printf("%d: %s, $%.2f." + "\n", count, d.getName(), d.getCost());
            count++;
        }
        return null;
    }

    @Override
    public double Price() {
        return cost;
    }

    @Override
    public List<String> getIngredients() {
        for (Ingridient d : ingridientList) {
            System.out.printf("%s - amount: %d " + "\n", d.getIngridientName(), d.getStock());
        }
        System.out.println(" ");
        return null;
    }




    public String getName() { return name; }

    public void setName(String name) {this.name = name; }

    public double getCost() { return cost; }

    public void setCost(double cost) { this.cost = cost; }

    public List<String> getRecipe() { return recipe; }

    public void setRecipe(List<String> recipe) { this.recipe = recipe; }

    public static ArrayList<DrinkType> getDrinkList() { return drinkList; }

    public static void setDrinkList(ArrayList<DrinkType> drinkList) { DrinkType.drinkList = drinkList; }


}
