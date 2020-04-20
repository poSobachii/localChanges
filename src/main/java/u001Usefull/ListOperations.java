package u001Usefull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ListOperations {

    public static void main(String[] args) {
//        firstObject();
        sortingList();
    }

    static void firstObject(){

        List<String> initializeList = List.of("String1", "String2");
        System.out.println(initializeList);
        List<String> listString = new LinkedList<>();
        listString.add("first add");
        listString.add("second add");
        listString.add("third add");
        System.out.println(listString);
        listString.add(0, "new add");
        System.out.println(listString);
    }

    static void sortingList(){

        List<Employee> list = new ArrayList<>();
        list.add( new Employee(1, "Lokesh", "Gupta") );
        list.add( new Employee(3, "Alex", "Gussin") );
        list.add( new Employee(2, "Brian", "Sux") );
        list.add( new Employee(2, "Neon", "Piper") );
        list.add( new Employee(1, "Witch", "Piper") );
        list.add( new Employee(3, "David", "Beckham") );
        list.add( new Employee(2, "Alex", "Beckham") );
        list.add( new Employee(3, "Brian", "Suxena") );

        System.out.println(list.toString());
//        Collections.sort(list, Comparator.comparing(Employee::getId).thenComparing(Employee::getName));
//        list.sort(Comparator.comparing(Employee::getId).thenComparing(Employee::getName));

//        list.sort(Comparator.comparing(Employee::getId));
//        Collections.sort(list.subList(2, list.size()), Comparator.comparing(Employee::getName));

        Collections.sort(list, new SurnameComporator());
        System.out.println(list.toString());


    }
    static class Employee {
        int id;
        String name;
        String surname;

        Employee(int id, String name, String surname){
            this.id = id;
            this.name = name;
            this.surname = surname;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        @Override
        public String toString() {
            return "\nEmployee id-" + id + " name-" + name + " surname-" + surname;
        }

    }

    static class SurnameComporator implements Comparator<Employee>{

        @Override
        public int compare(Employee emp1, Employee emp2) {
            if (emp1.getSurname().equals("Suxena")){
                return -1;
            }
            if (emp2.getSurname().equals("Suxena")){
                return 1;
            }
            return emp1.getName().compareTo(emp2.getName());
        }
    }
}
