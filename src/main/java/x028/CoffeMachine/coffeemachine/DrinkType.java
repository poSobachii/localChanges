package x028.CoffeMachine.coffeemachine;


public class DrinkType {

    private String name = "";
    private double cost = 0.00;
    private String [] recipe;


    public DrinkType(String name, double cost, String [] recipe){
        this.name = name;
        this.cost = cost;
        this.recipe = recipe;
    }

    public void setName(String name){ this.name = name; }

    public void setCost(double cost){ this.cost = cost; }

    public String getName(){ return name; }

    public double getCost(){ return cost; }

    public String[] getRecipe() { return recipe; }

    public void setRecipe(String[] recipe) { this.recipe = recipe; }

}
