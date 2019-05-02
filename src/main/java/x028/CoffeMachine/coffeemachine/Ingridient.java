package x028.CoffeMachine.coffeemachine;

public class Ingridient {
    private String name = "";
    private int stock = 0;


    public Ingridient(String name){
        this.name = name;
        this.stock = 10;
    }


    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getStock() { return stock; }

    public void setStock(int stock) { this.stock = stock; }


}
