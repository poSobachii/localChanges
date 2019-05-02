package x028.CoffeMachine.coffemachine2;

import java.util.*;

import static x028.CoffeMachine.coffemachine2.DrinkType.drinkList;
import static x028.CoffeMachine.coffemachine2.Ingridient.ingridientList;

public class TurnOn {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        addDrinks();
        addIngridients();
        while (true) {
            printAvailable();
            System.out.println("Type 'MENU' for help or Enter the # of desired drink:");
            String cmd = scan.next();
            switch (cmd) {
                case "1": prepareDrink("Black Coffee");break;
                case "2": prepareDrink("Caffe Latte");break;
                case "3": prepareDrink("Cappuccino");break;
                case "4": prepareDrink("White Coffee");break;
                case "MENU": showHelp();break;
                case "ING": printIngridients();break;
                case "RES": restock();break;
                case "EXIT": return;
                default:
                    System.out.println("There is not such drink. Type number of available drink or EXIT " + "\n");
            }
        }
    }

    private static void showHelp() {
        System.out.println("Enter number of desired drink to get one.");
        System.out.println("Type MENU to show this help.");
        System.out.println("Type ING to show ingridient status.");
        System.out.println("Type RES to restock ingridients.");
    }

    private static void printAvailable(){
        Drink drink = new DrinkType();
         drink.Price();
    }

    private static void printIngridients() {
        CoffeeMachine ingr = new Ingridient();
        String temp = " ";
        ingr.inStock(temp);
    }

    private static void prepareDrink(String name) throws InterruptedException {
        CoffeeMachine ingr = new Ingridient();
        if (ingr.validateOrder(name)) {
            if (payThePrice(name)) {
                System.out.println("Preparing " + name + " ...");
                drinkPreparingTime();
                    for (DrinkType d : drinkList) {
                        String tempname = d.getDrinkName();
                        if (tempname.equals(name)) {
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
                    System.out.println("Your " + name + " have been prepared ! Please enjoy it ! \n");

            }
        }
    }


    private static boolean payThePrice(String name) {
        double answer;
        double price = 0;
        String tempname;
        for (DrinkType d : drinkList) {
            tempname = d.getDrinkName();
            if (tempname.equals(name)) {
                price = d.getCost();
            }
        }
        System.out.println("Enter the amount of coins you insert (0.00 format): ");
        do {
            try {
                answer = scan.nextDouble();
            } catch (InputMismatchException k) {
                System.out.println("Invalid format. Please type number in form --> 0.00 ");
                scan.next();
                continue;
            }
            if (price == answer) {
                return true;
            } else if (price > answer) {
                System.out.println("Not enough money. Sorry :(" + "\n");
                return false;
            } else if (price < answer) {
                System.out.printf("%s - $%.2f" + "\n", "Too much ! here is your change", (answer - price));
                return true;
            }
        } while (true);
    }

    private static void drinkPreparingTime() throws InterruptedException {
        CoffeeMachine ingr = new Ingridient();
        ingr.isBusy();

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

    private static void restock() {
        ingridientList.clear();
        addIngridients();
    }
}
