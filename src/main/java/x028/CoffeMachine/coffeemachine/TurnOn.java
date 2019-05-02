package x028.CoffeMachine.coffeemachine;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TurnOn {
    static Scanner scan = new Scanner(System.in);

    private static List<DrinkType> drinkList = new ArrayList<DrinkType>();
    private static List<Ingridient> ingridientList = new ArrayList<Ingridient>();

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

    private static void printAvailable() {
        int count = 1;
        for (DrinkType d : drinkList) {
            System.out.printf("%d: %s, $%.2f." + "\n", count, d.getName(), d.getCost());
            count++;
        }
    }

    private static void printIngridients() {
        for (Ingridient d : ingridientList) {
            System.out.printf("%s - amount: %d " + "\n", d.getName(), d.getStock());
        }
        System.out.println(" ");
    }

    private static void prepareDrink(String name) throws InterruptedException {
        if (validateOrder(name)) {
            if (payThePrice(name)) {
                System.out.println("Preparing " + name + " ...");
                drinkPreparingTime();
                    for (DrinkType d : drinkList) {
                        String tempname = d.getName();
                        if (tempname.equals(name)) {
                            String[] recipe = d.getRecipe();
                            for (String s : recipe) {
                                for (Ingridient ingr : ingridientList) {
                                    if (s.equals(ingr.getName())) {
                                        ingr.setStock(ingr.getStock() - 1);
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
            tempname = d.getName();
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

    private static boolean validateOrder(String name) {
        for (DrinkType d : drinkList) {
            String tempname = d.getName();
            if (tempname.equals(name)) {
                String[] recipe = d.getRecipe();
                for (String s : recipe) {
                    for (Ingridient ingr : ingridientList) {
                        if (ingr.getName().equals(s) && ingr.getStock() == 0) {
                            System.out.println("Sorry but there is no more " + name + " :(" + "\n");
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private static boolean drinkPreparingTime() throws InterruptedException {
        int delay = 1;
        TimeUnit.SECONDS.sleep(delay);
        System.out.println("..adding Ingridient.....");
        TimeUnit.SECONDS.sleep(delay);
        System.out.println(".....adding Water.......");
        TimeUnit.SECONDS.sleep(delay);
        System.out.println("........Heating it up...");
        TimeUnit.SECONDS.sleep(delay);
        System.out.println("...........adding Milk..");
        TimeUnit.SECONDS.sleep(delay);
        return true;

    }

    private static void addDrinks() {
        addDrink("Black Coffee", 0.30, new String[]{"Coffee", "Sugar", "Cream"});
        addDrink("Caffe Latte", 0.40, new String[]{"Espresso", "Steamed Milk"});
        addDrink("Cappuccino", 0.50, new String[]{"Espresso", "Steamed Milk", "Foamed Milk"});
        addDrink("White Coffee", 0.30, new String[]{"Coffee", "Sugar", "Cream", "Steamed Milk"});
    }

    private static void addDrink(String name, Double cost, String[] ingrids) {
        drinkList.add(new DrinkType(name, cost, ingrids));
    }

    private static void addIngridients() {
        ingridientList.add(new Ingridient("Coffee"));
        ingridientList.add(new Ingridient("Sugar"));
        ingridientList.add(new Ingridient("Cream"));
        ingridientList.add(new Ingridient("Espresso"));
        ingridientList.add(new Ingridient("Steamed Milk"));
        ingridientList.add(new Ingridient("Foamed Milk"));

    }

    private static void restock() {
        ingridientList.clear();
        addIngridients();
    }
}
