package JsonExample.Controller;

public class JsonString {

    private String name;
    private String surname;
    private int age;
    private String price;

    public JsonString(){

    }

    public JsonString(String name, String surname, int age, String price) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.price = price;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
