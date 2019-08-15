package JsonExample.Controller;

import java.util.Map;

public class MappedObject {

    private String name;
    private String surname;
    private Integer age;
    private Map<String, String> adress;
    private Double price;

    public MappedObject(String name, String surname, Integer age, Map<String, String> adress, Double price) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.adress = adress;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public Map<String, String> getAdress() {
        return adress;
    }

    public double getPrice() {
        return price;
    }
}
