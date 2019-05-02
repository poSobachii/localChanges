package x028.CoffeMachine.coffemachine3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TurnOn {
    public static void main(String[] args) throws InterruptedException {
        addDrinks();
        addIngridients();

        Drink latte = new Latte();
        Drink cap = new Cappucino();

        DrinkOrder latteOrder = new DrinkOrder(latte);

        DrinkOrder capOrder = new DrinkOrder();
        capOrder.setDrinkType(cap);

        while (true) {
            Scanner scan = new Scanner(System.in);
            printAvailable();
            System.out.println("Enter the # of desired drink or 'EXIT' for exit:");
            String desired = scan.next();
            if (desired.equals("EXIT")){
                System.exit(666);
            } else if (desired.equals("ING")){
                printIngridients(); continue;
            }

            System.out.println("How much money ? / 0.00 format /");
            double moneyInserted = scan.nextDouble();
            System.out.println("How much sugar");
            int sugar = scan.nextInt();
//            double moneyInserted = 0.7;
//            int sugar = 16;
            switch (desired) {
                case "1": new DrinkOrder_old("Black Coffee",moneyInserted,sugar);break;
                case "2": new DrinkOrder_old("Caffe Latte", moneyInserted, sugar);break;
                case "3": new DrinkOrder_old("Cappuccino", moneyInserted, sugar);break;
                case "4": new DrinkOrder_old("White Coffee", moneyInserted, sugar);break;
                default:
                    System.out.println("There is no such drink. Type number of available drink or EXIT " + "\n");
            }
        }
    }

    private static void printAvailable(){
        Drink drink = new DrinkType();
        drink.message();
    }

    private static void printIngridients() {
        Drink ingr = new DrinkType();
        ingr.getIngredients();
    }


    private static void addDrinks() {
        addDrink("Black Coffee", 0.30, new ArrayList<>((Arrays.asList("Coffee", "Sugar", "Cream"))));
        addDrink("Caffe Latte", 0.40, new ArrayList<>((Arrays.asList("Espresso", "Steamed Milk"))));
        addDrink("Cappuccino", 0.50, new ArrayList<>((Arrays.asList("Espresso", "Steamed Milk", "Foamed Milk"))));
        addDrink("White Coffee", 0.30, new ArrayList<>((Arrays.asList ("Coffee", "Sugar", "Cream", "Steamed Milk"))));
    }

    private static void addDrink(String name, Double cost, ArrayList<String> ingrids) {
        new DrinkType(name, cost, ingrids);
    }

    private static void addIngridients() {
        new Ingridient("Coffee");
        new Ingridient("Sugar");
        new Ingridient("Cream");
        new Ingridient("Espresso");
        new Ingridient("Steamed Milk");
        new Ingridient("Foamed Milk");

    }
}
