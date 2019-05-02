package x028.CoffeMachine.coffemachine2;

import java.util.ArrayList;
import java.util.List;

public class DrinkType implements Drink{

    private String drinkName = "";
    private double cost = 0.00;
    private List<String> recipe;
    public static ArrayList<DrinkType> drinkList = new ArrayList<>();


    public DrinkType(String name, double cost, ArrayList<String> recipe){
        this.drinkName = name;
        this.cost = cost;
        this.recipe = recipe;
        drinkList.add(this);
    }

    public DrinkType(){

    }

    public void setDrinkName(String drinkName){ this.drinkName = drinkName; }

    public void setCost(double cost){ this.cost = cost; }

    public String getDrinkName(){ return drinkName; }

    public double getCost(){ return cost; }

    public static ArrayList<DrinkType> getDrinkList() {
        return drinkList;
    }

    public static void setDrinkList(ArrayList<DrinkType> drinkList) {
        DrinkType.drinkList = drinkList;
    }

    public List<String> getRecipe() { return recipe; }

    public void setRecipe(List<String> recipe) { this.recipe = recipe; }

    @Override
    public String message() {
        return drinkName;
    }

    @Override
    public double Price() {
        int count = 1;
        for (DrinkType d : drinkList) {
            System.out.printf("%d: %s, $%.2f." + "\n", count, d.getDrinkName(), d.getCost());
            count++;
        }
        return 0;
    }

    @Override
    public List<String> getIngredients() {
        return null;
    }
}
