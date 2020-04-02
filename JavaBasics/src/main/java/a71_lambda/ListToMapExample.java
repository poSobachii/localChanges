package a71_lambda;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class ListToMapExample {

    static List<Employeess> employeessList = new ArrayList<>();
    static Map<String, Employeess> employeessMap = new HashMap<>();

    public static void main(String[] args) {
        loadEssentials();
        employeessMap = proceedLambda4();


        results();
    }


    static void loadEssentials(){
        employeessList.add(new Employeess("1", "Jack", 20, "sailor"));
        employeessList.add(new Employeess("2", "Jhon", 22, "traitor"));
        employeessList.add(new Employeess("3", "Peet", 24, "dancor"));
        employeessList.add(new Employeess("4", "Bob", 26, "keeper"));
        employeessList.add(new Employeess("5", "Myke", 28, "firstlady"));
        employeessList.add(new Employeess("6", "Tom", 50, "actor"));
    }

    static Map<String, Employeess> proceedLambda1(){
      return employeessList.stream()
               .map(emplo -> emplo.getAge() != 24 ? setWrongAge(emplo) : emplo)
                .collect(toMap(Employeess::getId, x -> x));
    }

    static Map<String, Employeess> proceedLambda2(){
        return employeessList.stream()
                .map(emplo -> emplo.getAge() == 24 ? setWrongAge(emplo) : emplo)
                .collect(toMap(Employeess::getId, x -> x));
    }

    static Map<String, Employeess> proceedLambda3(){
        return employeessList.stream()
                .map(emplo -> emplo.getId().equals("5") ? setWrongAge(emplo) : emplo)
                .collect(toMap(Employeess::getId, x -> x));
    }

    static Map<String, Employeess> proceedLambda4(){
        return employeessList.stream()
                .map(emplo -> emplo.getAge() == 24 ? setWrongAge(emplo) : emplo)
                .map(emplo -> emplo.getAge() == 50 ? setWrongAge2(emplo) : emplo)
                .collect(toMap(Employeess::getId, x -> x));
    }


    static void results(){
        String test = null;
        System.out.println("So the results: --->");
    }

    static Employeess setWrongAge(Employeess employeess){
         employeess.setAge(50);
         return employeess;
    }

    static Employeess setWrongAge2(Employeess employeess){
        employeess.setAge(100);
        return employeess;
    }
}


class Employeess {

    private String id;
    private String name;
    private int age;
    private String position;

    public Employeess(String id, String name, int age, String position) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }
}