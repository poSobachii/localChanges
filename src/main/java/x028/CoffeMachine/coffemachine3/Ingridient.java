package x028.CoffeMachine.coffemachine3;

import java.util.ArrayList;
import java.util.List;

public class Ingridient  {

    private String ingridientName;
    private int stock;
    public static List<Ingridient> ingridientList = new ArrayList<Ingridient>();

    public Ingridient(String name){
        this.ingridientName = name;
        this.stock = 10;
        ingridientList.add(this);
    }

    public Ingridient(){

    }

    public String getIngridientName() {
        return ingridientName;
    }

    public void setIngridientName(String ingridientName) {
        this.ingridientName = ingridientName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public static List<Ingridient> getIngridientList() {
        return ingridientList;
    }

    public static void setIngridientList(List<Ingridient> ingridientList) {
        Ingridient.ingridientList = ingridientList;
    }

}
